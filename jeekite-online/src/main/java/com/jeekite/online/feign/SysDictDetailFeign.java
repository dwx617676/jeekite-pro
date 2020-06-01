package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysDictDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/sysDictDetail")
public interface SysDictDetailFeign {

    /***
     * SysDictDetail分页条件搜索实现
     * @param sysDictDetail
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysDictDetail sysDictDetail, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysDictDetail分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysDictDetail
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysDictDetail>> findList(@RequestBody(required = false) SysDictDetail sysDictDetail);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysDictDetail数据
     * @param sysDictDetail
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysDictDetail sysDictDetail,@PathVariable String id);

    /***
     * 新增SysDictDetail数据
     * @param sysDictDetail
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysDictDetail sysDictDetail);

    /***
     * 根据ID查询SysDictDetail数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysDictDetail> findById(@PathVariable String id);

    /***
     * 查询SysDictDetail全部数据
     * @return
     */
    @GetMapping
    Result<List<SysDictDetail>> findAll();
}