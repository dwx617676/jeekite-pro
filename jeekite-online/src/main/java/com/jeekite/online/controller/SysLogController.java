package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysLog;
import com.jeekite.online.service.SysLogService;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.common.result.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "SysLogController")
@RestController
@RequestMapping("/sysLog")
@CrossOrigin
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /***
     * SysLog分页条件搜索实现
     * @param sysLog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysLog条件分页查询",notes = "分页条件查询SysLog方法详情",tags = {"SysLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysLog对象",value = "传入JSON数据",required = false) SysLog sysLog, @PathVariable  int page, @PathVariable  int size){
        //调用SysLogService实现分页条件查询SysLog
        PageInfo<SysLog> pageInfo = sysLogService.findPage(sysLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysLog分页查询",notes = "分页查询SysLog方法详情",tags = {"SysLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysLogService实现分页查询SysLog
        PageInfo<SysLog> pageInfo = sysLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysLog
     * @return
     */
    @ApiOperation(value = "SysLog条件查询",notes = "条件查询SysLog方法详情",tags = {"SysLogController"})
    @PostMapping(value = "/search" )
    public Result<List<SysLog>> findList(@RequestBody(required = false) @ApiParam(name = "SysLog对象",value = "传入JSON数据",required = false) SysLog sysLog){
        //调用SysLogService实现条件查询SysLog
        List<SysLog> list = sysLogService.findList(sysLog);
        return new Result<List<SysLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysLog根据ID删除",notes = "根据ID删除SysLog方法详情",tags = {"SysLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysLogService实现根据主键删除
        sysLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysLog数据
     * @param sysLog
     * @param id
     * @return
     */
    @ApiOperation(value = "SysLog根据ID修改",notes = "根据ID修改SysLog方法详情",tags = {"SysLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysLog对象",value = "传入JSON数据",required = false) SysLog sysLog,@PathVariable String id){
        //设置主键值
        sysLog.setId(id);
        //调用SysLogService实现修改SysLog
        sysLogService.update(sysLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysLog数据
     * @param sysLog
     * @return
     */
    @ApiOperation(value = "SysLog添加",notes = "添加SysLog方法详情",tags = {"SysLogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysLog对象",value = "传入JSON数据",required = true) SysLog sysLog){
        //调用SysLogService实现添加SysLog
        sysLogService.add(sysLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysLog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysLog根据ID查询",notes = "根据ID查询SysLog方法详情",tags = {"SysLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysLog> findById(@PathVariable String id){
        //调用SysLogService实现根据主键查询SysLog
        SysLog sysLog = sysLogService.findById(id);
        return new Result<SysLog>(true,StatusCode.OK,"查询成功",sysLog);
    }

    /***
     * 查询SysLog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysLog",notes = "查询所SysLog有方法详情",tags = {"SysLogController"})
    @GetMapping
    public Result<List<SysLog>> findAll(){
        //调用SysLogService实现查询所有SysLog
        List<SysLog> list = sysLogService.findAll();
        return new Result<List<SysLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
