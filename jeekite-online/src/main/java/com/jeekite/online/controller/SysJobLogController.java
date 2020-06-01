package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysJobLog;
import com.jeekite.online.service.SysJobLogService;
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
@Api(value = "SysJobLogController")
@RestController
@RequestMapping("/sysJobLog")
@CrossOrigin
public class SysJobLogController {

    @Autowired
    private SysJobLogService sysJobLogService;

    /***
     * SysJobLog分页条件搜索实现
     * @param sysJobLog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysJobLog条件分页查询",notes = "分页条件查询SysJobLog方法详情",tags = {"SysJobLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysJobLog对象",value = "传入JSON数据",required = false) SysJobLog sysJobLog, @PathVariable  int page, @PathVariable  int size){
        //调用SysJobLogService实现分页条件查询SysJobLog
        PageInfo<SysJobLog> pageInfo = sysJobLogService.findPage(sysJobLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysJobLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysJobLog分页查询",notes = "分页查询SysJobLog方法详情",tags = {"SysJobLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysJobLogService实现分页查询SysJobLog
        PageInfo<SysJobLog> pageInfo = sysJobLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysJobLog
     * @return
     */
    @ApiOperation(value = "SysJobLog条件查询",notes = "条件查询SysJobLog方法详情",tags = {"SysJobLogController"})
    @PostMapping(value = "/search" )
    public Result<List<SysJobLog>> findList(@RequestBody(required = false) @ApiParam(name = "SysJobLog对象",value = "传入JSON数据",required = false) SysJobLog sysJobLog){
        //调用SysJobLogService实现条件查询SysJobLog
        List<SysJobLog> list = sysJobLogService.findList(sysJobLog);
        return new Result<List<SysJobLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysJobLog根据ID删除",notes = "根据ID删除SysJobLog方法详情",tags = {"SysJobLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysJobLogService实现根据主键删除
        sysJobLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysJobLog数据
     * @param sysJobLog
     * @param id
     * @return
     */
    @ApiOperation(value = "SysJobLog根据ID修改",notes = "根据ID修改SysJobLog方法详情",tags = {"SysJobLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysJobLog对象",value = "传入JSON数据",required = false) SysJobLog sysJobLog,@PathVariable String id){
        //设置主键值
        sysJobLog.setId(id);
        //调用SysJobLogService实现修改SysJobLog
        sysJobLogService.update(sysJobLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysJobLog数据
     * @param sysJobLog
     * @return
     */
    @ApiOperation(value = "SysJobLog添加",notes = "添加SysJobLog方法详情",tags = {"SysJobLogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysJobLog对象",value = "传入JSON数据",required = true) SysJobLog sysJobLog){
        //调用SysJobLogService实现添加SysJobLog
        sysJobLogService.add(sysJobLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysJobLog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysJobLog根据ID查询",notes = "根据ID查询SysJobLog方法详情",tags = {"SysJobLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysJobLog> findById(@PathVariable String id){
        //调用SysJobLogService实现根据主键查询SysJobLog
        SysJobLog sysJobLog = sysJobLogService.findById(id);
        return new Result<SysJobLog>(true,StatusCode.OK,"查询成功",sysJobLog);
    }

    /***
     * 查询SysJobLog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysJobLog",notes = "查询所SysJobLog有方法详情",tags = {"SysJobLogController"})
    @GetMapping
    public Result<List<SysJobLog>> findAll(){
        //调用SysJobLogService实现查询所有SysJobLog
        List<SysJobLog> list = sysJobLogService.findAll();
        return new Result<List<SysJobLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
