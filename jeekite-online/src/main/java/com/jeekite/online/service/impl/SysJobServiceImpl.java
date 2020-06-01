package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysJobMapper;
import com.jeekite.online.pojo.SysJob;
import com.jeekite.online.service.SysJobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysJob业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysJobServiceImpl implements SysJobService {

    @Autowired
    private SysJobMapper sysJobMapper;


    /**
     * SysJob条件+分页查询
     * @param sysJob 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysJob> findPage(SysJob sysJob, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysJob);
        //执行搜索
        return new PageInfo<SysJob>(sysJobMapper.selectByExample(example));
    }

    /**
     * SysJob分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysJob> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysJob>(sysJobMapper.selectAll());
    }

    /**
     * SysJob条件查询
     * @param sysJob
     * @return
     */
    @Override
    public List<SysJob> findList(SysJob sysJob){
        //构建查询条件
        Example example = createExample(sysJob);
        //根据构建的条件查询数据
        return sysJobMapper.selectByExample(example);
    }


    /**
     * SysJob构建查询对象
     * @param sysJob
     * @return
     */
    public Example createExample(SysJob sysJob){
        Example example=new Example(SysJob.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysJob!=null){
            // 任务id
            if(!StringUtils.isEmpty(sysJob.getId())){
                    criteria.andEqualTo("id",sysJob.getId());
            }
            // spring bean名称
            if(!StringUtils.isEmpty(sysJob.getBeanName())){
                    criteria.andEqualTo("beanName",sysJob.getBeanName());
            }
            // 参数
            if(!StringUtils.isEmpty(sysJob.getParams())){
                    criteria.andEqualTo("params",sysJob.getParams());
            }
            // cron表达式
            if(!StringUtils.isEmpty(sysJob.getCronExpression())){
                    criteria.andEqualTo("cronExpression",sysJob.getCronExpression());
            }
            // 任务状态  0：正常  1：暂停
            if(!StringUtils.isEmpty(sysJob.getStatus())){
                    criteria.andEqualTo("status",sysJob.getStatus());
            }
            // 备注
            if(!StringUtils.isEmpty(sysJob.getRemark())){
                    criteria.andEqualTo("remark",sysJob.getRemark());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysJob.getCreateTime())){
                    criteria.andEqualTo("createTime",sysJob.getCreateTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        sysJobMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysJob
     * @param sysJob
     */
    @Override
    public void update(SysJob sysJob){
        sysJobMapper.updateByPrimaryKey(sysJob);
    }

    /**
     * 增加SysJob
     * @param sysJob
     */
    @Override
    public void add(SysJob sysJob){
        sysJobMapper.insert(sysJob);
    }

    /**
     * 根据ID查询SysJob
     * @param id
     * @return
     */
    @Override
    public SysJob findById(String id){
        return  sysJobMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysJob全部数据
     * @return
     */
    @Override
    public List<SysJob> findAll() {
        return sysJobMapper.selectAll();
    }
}
