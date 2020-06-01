package com.jeekite.online.service;
import com.jeekite.online.pojo.SysGenerator;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysGenerator业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysGeneratorService {

    /***
     * SysGenerator多条件分页查询
     * @param sysGenerator
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysGenerator> findPage(SysGenerator sysGenerator, int page, int size);

    /***
     * SysGenerator分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysGenerator> findPage(int page, int size);

    /***
     * SysGenerator多条件搜索方法
     * @param sysGenerator
     * @return
     */
    List<SysGenerator> findList(SysGenerator sysGenerator);

    /***
     * 删除SysGenerator
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysGenerator数据
     * @param sysGenerator
     */
    void update(SysGenerator sysGenerator);

    /***
     * 新增SysGenerator
     * @param sysGenerator
     */
    void add(SysGenerator sysGenerator);

    /**
     * 根据ID查询SysGenerator
     * @param id
     * @return
     */
     SysGenerator findById(String id);

    /***
     * 查询所有SysGenerator
     * @return
     */
    List<SysGenerator> findAll();
}
