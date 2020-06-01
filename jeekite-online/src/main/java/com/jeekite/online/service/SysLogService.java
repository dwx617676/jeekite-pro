package com.jeekite.online.service;
import com.jeekite.online.pojo.SysLog;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysLog业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysLogService {

    /***
     * SysLog多条件分页查询
     * @param sysLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysLog> findPage(SysLog sysLog, int page, int size);

    /***
     * SysLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysLog> findPage(int page, int size);

    /***
     * SysLog多条件搜索方法
     * @param sysLog
     * @return
     */
    List<SysLog> findList(SysLog sysLog);

    /***
     * 删除SysLog
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysLog数据
     * @param sysLog
     */
    void update(SysLog sysLog);

    /***
     * 新增SysLog
     * @param sysLog
     */
    void add(SysLog sysLog);

    /**
     * 根据ID查询SysLog
     * @param id
     * @return
     */
     SysLog findById(String id);

    /***
     * 查询所有SysLog
     * @return
     */
    List<SysLog> findAll();
}
