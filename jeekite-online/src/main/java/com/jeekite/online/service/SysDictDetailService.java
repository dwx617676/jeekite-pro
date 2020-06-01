package com.jeekite.online.service;
import com.jeekite.online.pojo.SysDictDetail;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysDictDetail业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysDictDetailService {

    /***
     * SysDictDetail多条件分页查询
     * @param sysDictDetail
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDictDetail> findPage(SysDictDetail sysDictDetail, int page, int size);

    /***
     * SysDictDetail分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysDictDetail> findPage(int page, int size);

    /***
     * SysDictDetail多条件搜索方法
     * @param sysDictDetail
     * @return
     */
    List<SysDictDetail> findList(SysDictDetail sysDictDetail);

    /***
     * 删除SysDictDetail
     * @param id
     */
    void delete(String id);

    /***
     * 修改SysDictDetail数据
     * @param sysDictDetail
     */
    void update(SysDictDetail sysDictDetail);

    /***
     * 新增SysDictDetail
     * @param sysDictDetail
     */
    void add(SysDictDetail sysDictDetail);

    /**
     * 根据ID查询SysDictDetail
     * @param id
     * @return
     */
     SysDictDetail findById(String id);

    /***
     * 查询所有SysDictDetail
     * @return
     */
    List<SysDictDetail> findAll();
}
