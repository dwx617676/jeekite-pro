package com.jeekite.sys.service;
import com.jeekite.sys.entity.SysRolePermission;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:dudianlong
 * @Description:SysRolePermission业务层接口
 * @Date 2020/5/14 0:16
 *****/
public interface SysRolePermissionService {

    /***
     * SysRolePermission多条件分页查询
     * @param sysRolePermission
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysRolePermission> findPage(SysRolePermission sysRolePermission, int page, int size);

    /***
     * SysRolePermission分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysRolePermission> findPage(int page, int size);

    /***
     * SysRolePermission多条件搜索方法
     * @param sysRolePermission
     * @return
     */
    List<SysRolePermission> findList(SysRolePermission sysRolePermission);

    /***
     * 删除SysRolePermission
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysRolePermission数据
     * @param sysRolePermission
     */
    void update(SysRolePermission sysRolePermission);

    /***
     * 新增SysRolePermission
     * @param sysRolePermission
     */
    void add(SysRolePermission sysRolePermission);

    /**
     * 根据ID查询SysRolePermission
     * @param id
     * @return
     */
     SysRolePermission findById(String id);

    /***
     * 查询所有SysRolePermission
     * @return
     */
    List<SysRolePermission> findAll();
}
