package com.jeekite.online.service;
import com.jeekite.online.pojo.SysJob;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysJob业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysJobService {

    /***
     * SysJob多条件分页查询
     * @param sysJob
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysJob> findPage(SysJob sysJob, int page, int size);

    /***
     * SysJob分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysJob> findPage(int page, int size);

    /***
     * SysJob多条件搜索方法
     * @param sysJob
     * @return
     */
    List<SysJob> findList(SysJob sysJob);

    /***
     * 删除SysJob
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysJob数据
     * @param sysJob
     */
    void update(SysJob sysJob);

    /***
     * 新增SysJob
     * @param sysJob
     */
    void add(SysJob sysJob);

    /**
     * 根据ID查询SysJob
     * @param id
     * @return
     */
     SysJob findById(String id);

    /***
     * 查询所有SysJob
     * @return
     */
    List<SysJob> findAll();
}
