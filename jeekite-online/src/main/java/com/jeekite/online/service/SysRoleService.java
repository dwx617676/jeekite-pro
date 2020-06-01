package com.jeekite.online.service;
import com.jeekite.online.pojo.SysRole;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysRole业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysRoleService {

    /***
     * SysRole多条件分页查询
     * @param sysRole
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysRole> findPage(SysRole sysRole, int page, int size);

    /***
     * SysRole分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysRole> findPage(int page, int size);

    /***
     * SysRole多条件搜索方法
     * @param sysRole
     * @return
     */
    List<SysRole> findList(SysRole sysRole);

    /***
     * 删除SysRole
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysRole数据
     * @param sysRole
     */
    void update(SysRole sysRole);

    /***
     * 新增SysRole
     * @param sysRole
     */
    void add(SysRole sysRole);

    /**
     * 根据ID查询SysRole
     * @param id
     * @return
     */
     SysRole findById(String id);

    /***
     * 查询所有SysRole
     * @return
     */
    List<SysRole> findAll();
}
