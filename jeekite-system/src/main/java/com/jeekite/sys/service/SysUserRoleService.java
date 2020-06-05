package com.jeekite.sys.service;
import com.jeekite.sys.entity.SysUserRole;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:dudianlong
 * @Description:SysUserRole业务层接口
 * @Date 2020/5/14 0:16
 *****/
public interface SysUserRoleService {

    /***
     * SysUserRole多条件分页查询
     * @param sysUserRole
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysUserRole> findPage(SysUserRole sysUserRole, int page, int size);

    /***
     * SysUserRole分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysUserRole> findPage(int page, int size);

    /***
     * SysUserRole多条件搜索方法
     * @param sysUserRole
     * @return
     */
    List<SysUserRole> findList(SysUserRole sysUserRole);

    /***
     * 删除SysUserRole
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysUserRole数据
     * @param sysUserRole
     */
    void update(SysUserRole sysUserRole);

    /***
     * 新增SysUserRole
     * @param sysUserRole
     */
    void add(SysUserRole sysUserRole);

    /**
     * 根据ID查询SysUserRole
     * @param id
     * @return
     */
     SysUserRole findById(String id);

    /***
     * 查询所有SysUserRole
     * @return
     */
    List<SysUserRole> findAll();
}
