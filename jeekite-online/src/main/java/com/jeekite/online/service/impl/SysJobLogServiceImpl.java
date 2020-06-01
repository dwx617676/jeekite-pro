package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysJobLogMapper;
import com.jeekite.online.pojo.SysJobLog;
import com.jeekite.online.service.SysJobLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysJobLog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysJobLogServiceImpl implements SysJobLogService {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;


    /**
     * SysJobLog条件+分页查询
     * @param sysJobLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysJobLog> findPage(SysJobLog sysJobLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysJobLog);
        //执行搜索
        return new PageInfo<SysJobLog>(sysJobLogMapper.selectByExample(example));
    }

    /**
     * SysJobLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysJobLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysJobLog>(sysJobLogMapper.selectAll());
    }

    /**
     * SysJobLog条件查询
     * @param sysJobLog
     * @return
     */
    @Override
    public List<SysJobLog> findList(SysJobLog sysJobLog){
        //构建查询条件
        Example example = createExample(sysJobLog);
        //根据构建的条件查询数据
        return sysJobLogMapper.selectByExample(example);
    }


    /**
     * SysJobLog构建查询对象
     * @param sysJobLog
     * @return
     */
    public Example createExample(SysJobLog sysJobLog){
        Example example=new Example(SysJobLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysJobLog!=null){
            // 任务日志id
            if(!StringUtils.isEmpty(sysJobLog.getId())){
                    criteria.andEqualTo("id",sysJobLog.getId());
            }
            // 任务id
            if(!StringUtils.isEmpty(sysJobLog.getJobId())){
                    criteria.andEqualTo("jobId",sysJobLog.getJobId());
            }
            // spring bean名称
            if(!StringUtils.isEmpty(sysJobLog.getBeanName())){
                    criteria.andEqualTo("beanName",sysJobLog.getBeanName());
            }
            // 参数
            if(!StringUtils.isEmpty(sysJobLog.getParams())){
                    criteria.andEqualTo("params",sysJobLog.getParams());
            }
            // 任务状态    0：成功    1：失败
            if(!StringUtils.isEmpty(sysJobLog.getStatus())){
                    criteria.andEqualTo("status",sysJobLog.getStatus());
            }
            // 失败信息
            if(!StringUtils.isEmpty(sysJobLog.getError())){
                    criteria.andEqualTo("error",sysJobLog.getError());
            }
            // 耗时(单位：毫秒)
            if(!StringUtils.isEmpty(sysJobLog.getTimes())){
                    criteria.andEqualTo("times",sysJobLog.getTimes());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysJobLog.getCreateTime())){
                    criteria.andEqualTo("createTime",sysJobLog.getCreateTime());
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
        sysJobLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysJobLog
     * @param sysJobLog
     */
    @Override
    public void update(SysJobLog sysJobLog){
        sysJobLogMapper.updateByPrimaryKey(sysJobLog);
    }

    /**
     * 增加SysJobLog
     * @param sysJobLog
     */
    @Override
    public void add(SysJobLog sysJobLog){
        sysJobLogMapper.insert(sysJobLog);
    }

    /**
     * 根据ID查询SysJobLog
     * @param id
     * @return
     */
    @Override
    public SysJobLog findById(String id){
        return  sysJobLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysJobLog全部数据
     * @return
     */
    @Override
    public List<SysJobLog> findAll() {
        return sysJobLogMapper.selectAll();
    }
}
