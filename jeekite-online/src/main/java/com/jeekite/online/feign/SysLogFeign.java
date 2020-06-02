package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@FeignClient(name="user")
@RequestMapping("/sysLog")
public interface SysLogFeign {

    /***
     * SysLog分页条件搜索实现
     * @param sysLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysLog sysLog, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysLog
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysLog>> findList(@RequestBody(required = false) SysLog sysLog);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysLog数据
     * @param sysLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysLog sysLog,@PathVariable String id);

    /***
     * 新增SysLog数据
     * @param sysLog
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysLog sysLog);

    /***
     * 根据ID查询SysLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysLog> findById(@PathVariable String id);

    /***
     * 查询SysLog全部数据
     * @return
     */
    @GetMapping
    Result<List<SysLog>> findAll();
}