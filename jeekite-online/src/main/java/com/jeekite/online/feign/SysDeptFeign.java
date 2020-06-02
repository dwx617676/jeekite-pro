package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysDept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@FeignClient(name="user")
@RequestMapping("/sysDept")
public interface SysDeptFeign {

    /***
     * SysDept分页条件搜索实现
     * @param sysDept
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysDept sysDept, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysDept分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysDept
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysDept>> findList(@RequestBody(required = false) SysDept sysDept);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysDept数据
     * @param sysDept
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysDept sysDept,@PathVariable String id);

    /***
     * 新增SysDept数据
     * @param sysDept
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysDept sysDept);

    /***
     * 根据ID查询SysDept数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysDept> findById(@PathVariable String id);

    /***
     * 查询SysDept全部数据
     * @return
     */
    @GetMapping
    Result<List<SysDept>> findAll();
}