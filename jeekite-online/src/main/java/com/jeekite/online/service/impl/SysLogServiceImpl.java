package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysLogMapper;
import com.jeekite.online.pojo.SysLog;
import com.jeekite.online.service.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysLog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;


    /**
     * SysLog条件+分页查询
     * @param sysLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysLog> findPage(SysLog sysLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysLog);
        //执行搜索
        return new PageInfo<SysLog>(sysLogMapper.selectByExample(example));
    }

    /**
     * SysLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysLog>(sysLogMapper.selectAll());
    }

    /**
     * SysLog条件查询
     * @param sysLog
     * @return
     */
    @Override
    public List<SysLog> findList(SysLog sysLog){
        //构建查询条件
        Example example = createExample(sysLog);
        //根据构建的条件查询数据
        return sysLogMapper.selectByExample(example);
    }


    /**
     * SysLog构建查询对象
     * @param sysLog
     * @return
     */
    public Example createExample(SysLog sysLog){
        Example example=new Example(SysLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysLog!=null){
            // 
            if(!StringUtils.isEmpty(sysLog.getId())){
                    criteria.andEqualTo("id",sysLog.getId());
            }
            // 用户id
            if(!StringUtils.isEmpty(sysLog.getUserId())){
                    criteria.andEqualTo("userId",sysLog.getUserId());
            }
            // 用户名
            if(!StringUtils.isEmpty(sysLog.getUsername())){
                    criteria.andLike("username","%"+sysLog.getUsername()+"%");
            }
            // 用户操作
            if(!StringUtils.isEmpty(sysLog.getOperation())){
                    criteria.andEqualTo("operation",sysLog.getOperation());
            }
            // 响应时间
            if(!StringUtils.isEmpty(sysLog.getTime())){
                    criteria.andEqualTo("time",sysLog.getTime());
            }
            // 请求方法
            if(!StringUtils.isEmpty(sysLog.getMethod())){
                    criteria.andEqualTo("method",sysLog.getMethod());
            }
            // 请求参数
            if(!StringUtils.isEmpty(sysLog.getParams())){
                    criteria.andEqualTo("params",sysLog.getParams());
            }
            // IP地址
            if(!StringUtils.isEmpty(sysLog.getIp())){
                    criteria.andEqualTo("ip",sysLog.getIp());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysLog.getCreateTime())){
                    criteria.andEqualTo("createTime",sysLog.getCreateTime());
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
        sysLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysLog
     * @param sysLog
     */
    @Override
    public void update(SysLog sysLog){
        sysLogMapper.updateByPrimaryKey(sysLog);
    }

    /**
     * 增加SysLog
     * @param sysLog
     */
    @Override
    public void add(SysLog sysLog){
        sysLogMapper.insert(sysLog);
    }

    /**
     * 根据ID查询SysLog
     * @param id
     * @return
     */
    @Override
    public SysLog findById(String id){
        return  sysLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysLog全部数据
     * @return
     */
    @Override
    public List<SysLog> findAll() {
        return sysLogMapper.selectAll();
    }
}
