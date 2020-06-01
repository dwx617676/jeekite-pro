package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysDict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/sysDict")
public interface SysDictFeign {

    /***
     * SysDict分页条件搜索实现
     * @param sysDict
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysDict sysDict, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysDict分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysDict
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysDict>> findList(@RequestBody(required = false) SysDict sysDict);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysDict数据
     * @param sysDict
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysDict sysDict,@PathVariable String id);

    /***
     * 新增SysDict数据
     * @param sysDict
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysDict sysDict);

    /***
     * 根据ID查询SysDict数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysDict> findById(@PathVariable String id);

    /***
     * 查询SysDict全部数据
     * @return
     */
    @GetMapping
    Result<List<SysDict>> findAll();
}