package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysGenerator;
import com.jeekite.online.service.SysGeneratorService;
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
@Api(value = "SysGeneratorController")
@RestController
@RequestMapping("/sysGenerator")
@CrossOrigin
public class SysGeneratorController {

    @Autowired
    private SysGeneratorService sysGeneratorService;

    /***
     * SysGenerator分页条件搜索实现
     * @param sysGenerator
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysGenerator条件分页查询",notes = "分页条件查询SysGenerator方法详情",tags = {"SysGeneratorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysGenerator对象",value = "传入JSON数据",required = false) SysGenerator sysGenerator, @PathVariable  int page, @PathVariable  int size){
        //调用SysGeneratorService实现分页条件查询SysGenerator
        PageInfo<SysGenerator> pageInfo = sysGeneratorService.findPage(sysGenerator, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysGenerator分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysGenerator分页查询",notes = "分页查询SysGenerator方法详情",tags = {"SysGeneratorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysGeneratorService实现分页查询SysGenerator
        PageInfo<SysGenerator> pageInfo = sysGeneratorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysGenerator
     * @return
     */
    @ApiOperation(value = "SysGenerator条件查询",notes = "条件查询SysGenerator方法详情",tags = {"SysGeneratorController"})
    @PostMapping(value = "/search" )
    public Result<List<SysGenerator>> findList(@RequestBody(required = false) @ApiParam(name = "SysGenerator对象",value = "传入JSON数据",required = false) SysGenerator sysGenerator){
        //调用SysGeneratorService实现条件查询SysGenerator
        List<SysGenerator> list = sysGeneratorService.findList(sysGenerator);
        return new Result<List<SysGenerator>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysGenerator根据ID删除",notes = "根据ID删除SysGenerator方法详情",tags = {"SysGeneratorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysGeneratorService实现根据主键删除
        sysGeneratorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysGenerator数据
     * @param sysGenerator
     * @param id
     * @return
     */
    @ApiOperation(value = "SysGenerator根据ID修改",notes = "根据ID修改SysGenerator方法详情",tags = {"SysGeneratorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysGenerator对象",value = "传入JSON数据",required = false) SysGenerator sysGenerator,@PathVariable String id){
        //设置主键值
        sysGenerator.setId(id);
        //调用SysGeneratorService实现修改SysGenerator
        sysGeneratorService.update(sysGenerator);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysGenerator数据
     * @param sysGenerator
     * @return
     */
    @ApiOperation(value = "SysGenerator添加",notes = "添加SysGenerator方法详情",tags = {"SysGeneratorController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysGenerator对象",value = "传入JSON数据",required = true) SysGenerator sysGenerator){
        //调用SysGeneratorService实现添加SysGenerator
        sysGeneratorService.add(sysGenerator);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysGenerator数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysGenerator根据ID查询",notes = "根据ID查询SysGenerator方法详情",tags = {"SysGeneratorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysGenerator> findById(@PathVariable String id){
        //调用SysGeneratorService实现根据主键查询SysGenerator
        SysGenerator sysGenerator = sysGeneratorService.findById(id);
        return new Result<SysGenerator>(true,StatusCode.OK,"查询成功",sysGenerator);
    }

    /***
     * 查询SysGenerator全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysGenerator",notes = "查询所SysGenerator有方法详情",tags = {"SysGeneratorController"})
    @GetMapping
    public Result<List<SysGenerator>> findAll(){
        //调用SysGeneratorService实现查询所有SysGenerator
        List<SysGenerator> list = sysGeneratorService.findAll();
        return new Result<List<SysGenerator>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
