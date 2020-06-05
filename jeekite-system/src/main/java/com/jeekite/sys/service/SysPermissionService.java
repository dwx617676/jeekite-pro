package com.jeekite.sys.service;
import com.jeekite.sys.entity.SysPermission;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:dudianlong
 * @Description:SysPermission业务层接口
 * @Date 2020/5/14 0:16
 *****/
public interface SysPermissionService {

    /***
     * SysPermission多条件分页查询
     * @param sysPermission
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysPermission> findPage(SysPermission sysPermission, int page, int size);

    /***
     * SysPermission分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysPermission> findPage(int page, int size);

    /***
     * SysPermission多条件搜索方法
     * @param sysPermission
     * @return
     */
    List<SysPermission> findList(SysPermission sysPermission);

    /***
     * 删除SysPermission
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysPermission数据
     * @param sysPermission
     */
    void update(SysPermission sysPermission);

    /***
     * 新增SysPermission
     * @param sysPermission
     */
    void add(SysPermission sysPermission);

    /**
     * 根据ID查询SysPermission
     * @param id
     * @return
     */
     SysPermission findById(String id);

    /***
     * 查询所有SysPermission
     * @return
     */
    List<SysPermission> findAll();
}
