package com.jeekite.sys.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.sys.entity.SysPermission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@FeignClient(name="user")
@RequestMapping("/sysPermission")
public interface SysPermissionFeign {

    /***
     * SysPermission分页条件搜索实现
     * @param sysPermission
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysPermission sysPermission, @PathVariable int page, @PathVariable int size);

    /***
     * SysPermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param sysPermission
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysPermission>> findList(@RequestBody(required = false) SysPermission sysPermission);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysPermission数据
     * @param sysPermission
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysPermission sysPermission, @PathVariable String id);

    /***
     * 新增SysPermission数据
     * @param sysPermission
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysPermission sysPermission);

    /***
     * 根据ID查询SysPermission数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysPermission> findById(@PathVariable String id);

    /***
     * 查询SysPermission全部数据
     * @return
     */
    @GetMapping
    Result<List<SysPermission>> findAll();
}