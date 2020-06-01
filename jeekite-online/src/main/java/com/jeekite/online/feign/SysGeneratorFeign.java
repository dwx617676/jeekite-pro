package com.jeekite.online.feign;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.online.pojo.SysGenerator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/sysGenerator")
public interface SysGeneratorFeign {

    /***
     * SysGenerator分页条件搜索实现
     * @param sysGenerator
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysGenerator sysGenerator, @PathVariable  int page, @PathVariable  int size);

    /***
     * SysGenerator分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysGenerator
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysGenerator>> findList(@RequestBody(required = false) SysGenerator sysGenerator);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改SysGenerator数据
     * @param sysGenerator
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysGenerator sysGenerator,@PathVariable String id);

    /***
     * 新增SysGenerator数据
     * @param sysGenerator
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysGenerator sysGenerator);

    /***
     * 根据ID查询SysGenerator数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysGenerator> findById(@PathVariable String id);

    /***
     * 查询SysGenerator全部数据
     * @return
     */
    @GetMapping
    Result<List<SysGenerator>> findAll();
}