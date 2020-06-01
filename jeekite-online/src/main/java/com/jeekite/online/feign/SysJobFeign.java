package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysJob;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/sysJob")
public interface SysJobFeign {

    /***
     * SysJob分页条件搜索实现
     * @param sysJob
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysJob sysJob, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysJob分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysJob
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysJob>> findList(@RequestBody(required = false) SysJob sysJob);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysJob数据
     * @param sysJob
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysJob sysJob,@PathVariable String id);

    /***
     * 新增SysJob数据
     * @param sysJob
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysJob sysJob);

    /***
     * 根据ID查询SysJob数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysJob> findById(@PathVariable String id);

    /***
     * 查询SysJob全部数据
     * @return
     */
    @GetMapping
    Result<List<SysJob>> findAll();
}