package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysJob;
import com.jeekite.online.service.SysJobService;
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
@Api(value = "SysJobController")
@RestController
@RequestMapping("/sysJob")
@CrossOrigin
public class SysJobController {

    @Autowired
    private SysJobService sysJobService;

    /***
     * SysJob分页条件搜索实现
     * @param sysJob
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysJob条件分页查询",notes = "分页条件查询SysJob方法详情",tags = {"SysJobController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysJob对象",value = "传入JSON数据",required = false) SysJob sysJob, @PathVariable  int page, @PathVariable  int size){
        //调用SysJobService实现分页条件查询SysJob
        PageInfo<SysJob> pageInfo = sysJobService.findPage(sysJob, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysJob分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysJob分页查询",notes = "分页查询SysJob方法详情",tags = {"SysJobController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysJobService实现分页查询SysJob
        PageInfo<SysJob> pageInfo = sysJobService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysJob
     * @return
     */
    @ApiOperation(value = "SysJob条件查询",notes = "条件查询SysJob方法详情",tags = {"SysJobController"})
    @PostMapping(value = "/search" )
    public Result<List<SysJob>> findList(@RequestBody(required = false) @ApiParam(name = "SysJob对象",value = "传入JSON数据",required = false) SysJob sysJob){
        //调用SysJobService实现条件查询SysJob
        List<SysJob> list = sysJobService.findList(sysJob);
        return new Result<List<SysJob>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysJob根据ID删除",notes = "根据ID删除SysJob方法详情",tags = {"SysJobController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysJobService实现根据主键删除
        sysJobService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysJob数据
     * @param sysJob
     * @param id
     * @return
     */
    @ApiOperation(value = "SysJob根据ID修改",notes = "根据ID修改SysJob方法详情",tags = {"SysJobController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysJob对象",value = "传入JSON数据",required = false) SysJob sysJob,@PathVariable String id){
        //设置主键值
        sysJob.setId(id);
        //调用SysJobService实现修改SysJob
        sysJobService.update(sysJob);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysJob数据
     * @param sysJob
     * @return
     */
    @ApiOperation(value = "SysJob添加",notes = "添加SysJob方法详情",tags = {"SysJobController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysJob对象",value = "传入JSON数据",required = true) SysJob sysJob){
        //调用SysJobService实现添加SysJob
        sysJobService.add(sysJob);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysJob数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysJob根据ID查询",notes = "根据ID查询SysJob方法详情",tags = {"SysJobController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysJob> findById(@PathVariable String id){
        //调用SysJobService实现根据主键查询SysJob
        SysJob sysJob = sysJobService.findById(id);
        return new Result<SysJob>(true,StatusCode.OK,"查询成功",sysJob);
    }

    /***
     * 查询SysJob全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysJob",notes = "查询所SysJob有方法详情",tags = {"SysJobController"})
    @GetMapping
    public Result<List<SysJob>> findAll(){
        //调用SysJobService实现查询所有SysJob
        List<SysJob> list = sysJobService.findAll();
        return new Result<List<SysJob>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
