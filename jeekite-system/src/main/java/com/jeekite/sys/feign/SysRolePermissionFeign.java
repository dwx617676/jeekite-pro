package com.jeekite.sys.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.sys.entity.SysRolePermission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@FeignClient(name="user")
@RequestMapping("/sysRolePermission")
public interface SysRolePermissionFeign {

    /***
     * SysRolePermission分页条件搜索实现
     * @param sysRolePermission
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysRolePermission sysRolePermission, @PathVariable int page, @PathVariable int size);

    /***
     * SysRolePermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param sysRolePermission
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysRolePermission>> findList(@RequestBody(required = false) SysRolePermission sysRolePermission);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysRolePermission数据
     * @param sysRolePermission
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysRolePermission sysRolePermission, @PathVariable String id);

    /***
     * 新增SysRolePermission数据
     * @param sysRolePermission
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysRolePermission sysRolePermission);

    /***
     * 根据ID查询SysRolePermission数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysRolePermission> findById(@PathVariable String id);

    /***
     * 查询SysRolePermission全部数据
     * @return
     */
    @GetMapping
    Result<List<SysRolePermission>> findAll();
}