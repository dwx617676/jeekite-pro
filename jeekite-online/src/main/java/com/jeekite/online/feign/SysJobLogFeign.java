package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysJobLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/sysJobLog")
public interface SysJobLogFeign {

    /***
     * SysJobLog分页条件搜索实现
     * @param sysJobLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysJobLog sysJobLog, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysJobLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysJobLog
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysJobLog>> findList(@RequestBody(required = false) SysJobLog sysJobLog);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysJobLog数据
     * @param sysJobLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysJobLog sysJobLog,@PathVariable String id);

    /***
     * 新增SysJobLog数据
     * @param sysJobLog
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysJobLog sysJobLog);

    /***
     * 根据ID查询SysJobLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysJobLog> findById(@PathVariable String id);

    /***
     * 查询SysJobLog全部数据
     * @return
     */
    @GetMapping
    Result<List<SysJobLog>> findAll();
}