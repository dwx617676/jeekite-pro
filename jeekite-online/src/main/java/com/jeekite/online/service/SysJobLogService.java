package com.jeekite.online.service;
import com.jeekite.online.pojo.SysJobLog;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysJobLog业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysJobLogService {

    /***
     * SysJobLog多条件分页查询
     * @param sysJobLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysJobLog> findPage(SysJobLog sysJobLog, int page, int size);

    /***
     * SysJobLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysJobLog> findPage(int page, int size);

    /***
     * SysJobLog多条件搜索方法
     * @param sysJobLog
     * @return
     */
    List<SysJobLog> findList(SysJobLog sysJobLog);

    /***
     * 删除SysJobLog
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysJobLog数据
     * @param sysJobLog
     */
    void update(SysJobLog sysJobLog);

    /***
     * 新增SysJobLog
     * @param sysJobLog
     */
    void add(SysJobLog sysJobLog);

    /**
     * 根据ID查询SysJobLog
     * @param id
     * @return
     */
     SysJobLog findById(String id);

    /***
     * 查询所有SysJobLog
     * @return
     */
    List<SysJobLog> findAll();
}
