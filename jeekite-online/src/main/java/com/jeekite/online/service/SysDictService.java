package com.jeekite.online.service;
import com.jeekite.online.pojo.SysDict;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysDict业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysDictService {

    /***
     * SysDict多条件分页查询
     * @param sysDict
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDict> findPage(SysDict sysDict, int page, int size);

    /***
     * SysDict分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDict> findPage(int page, int size);

    /***
     * SysDict多条件搜索方法
     * @param sysDict
     * @return
     */
    List<SysDict> findList(SysDict sysDict);

    /***
     * 删除SysDict
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysDict数据
     * @param sysDict
     */
    void update(SysDict sysDict);

    /***
     * 新增SysDict
     * @param sysDict
     */
    void add(SysDict sysDict);

    /**
     * 根据ID查询SysDict
     * @param id
     * @return
     */
     SysDict findById(String id);

    /***
     * 查询所有SysDict
     * @return
     */
    List<SysDict> findAll();
}
