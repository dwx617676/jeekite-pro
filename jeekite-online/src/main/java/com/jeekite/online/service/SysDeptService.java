package com.jeekite.online.service;
import com.jeekite.online.pojo.SysDept;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:dudianlong
 * @Description:SysDept业务层接口
 * @Date 2020/5/14 0:16
 *****/
public interface SysDeptService {

    /***
     * SysDept多条件分页查询
     * @param sysDept
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDept> findPage(SysDept sysDept, int page, int size);

    /***
     * SysDept分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDept> findPage(int page, int size);

    /***
     * SysDept多条件搜索方法
     * @param sysDept
     * @return
     */
    List<SysDept> findList(SysDept sysDept);

    /***
     * 删除SysDept
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysDept数据
     * @param sysDept
     */
    void update(SysDept sysDept);

    /***
     * 新增SysDept
     * @param sysDept
     */
    void add(SysDept sysDept);

    /**
     * 根据ID查询SysDept
     * @param id
     * @return
     */
     SysDept findById(String id);

    /***
     * 查询所有SysDept
     * @return
     */
    List<SysDept> findAll();
}
