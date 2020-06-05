package com.jeekite.sys.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.sys.entity.SysUserRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@FeignClient(name="user")
@RequestMapping("/sysUserRole")
public interface SysUserRoleFeign {

    /***
     * SysUserRole分页条件搜索实现
     * @param sysUserRole
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysUserRole sysUserRole, @PathVariable int page, @PathVariable int size);

    /***
     * SysUserRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param sysUserRole
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysUserRole>> findList(@RequestBody(required = false) SysUserRole sysUserRole);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysUserRole数据
     * @param sysUserRole
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysUserRole sysUserRole, @PathVariable String id);

    /***
     * 新增SysUserRole数据
     * @param sysUserRole
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysUserRole sysUserRole);

    /***
     * 根据ID查询SysUserRole数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysUserRole> findById(@PathVariable String id);

    /***
     * 查询SysUserRole全部数据
     * @return
     */
    @GetMapping
    Result<List<SysUserRole>> findAll();
}