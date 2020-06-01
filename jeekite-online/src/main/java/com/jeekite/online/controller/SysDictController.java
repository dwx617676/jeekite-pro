package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysDict;
import com.jeekite.online.service.SysDictService;
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
@Api(value = "SysDictController")
@RestController
@RequestMapping("/sysDict")
@CrossOrigin
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    /***
     * SysDict分页条件搜索实现
     * @param sysDict
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysDict条件分页查询",notes = "分页条件查询SysDict方法详情",tags = {"SysDictController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysDict对象",value = "传入JSON数据",required = false) SysDict sysDict, @PathVariable  int page, @PathVariable  int size){
        //调用SysDictService实现分页条件查询SysDict
        PageInfo<SysDict> pageInfo = sysDictService.findPage(sysDict, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysDict分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysDict分页查询",notes = "分页查询SysDict方法详情",tags = {"SysDictController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysDictService实现分页查询SysDict
        PageInfo<SysDict> pageInfo = sysDictService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysDict
     * @return
     */
    @ApiOperation(value = "SysDict条件查询",notes = "条件查询SysDict方法详情",tags = {"SysDictController"})
    @PostMapping(value = "/search" )
    public Result<List<SysDict>> findList(@RequestBody(required = false) @ApiParam(name = "SysDict对象",value = "传入JSON数据",required = false) SysDict sysDict){
        //调用SysDictService实现条件查询SysDict
        List<SysDict> list = sysDictService.findList(sysDict);
        return new Result<List<SysDict>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDict根据ID删除",notes = "根据ID删除SysDict方法详情",tags = {"SysDictController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysDictService实现根据主键删除
        sysDictService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysDict数据
     * @param sysDict
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDict根据ID修改",notes = "根据ID修改SysDict方法详情",tags = {"SysDictController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysDict对象",value = "传入JSON数据",required = false) SysDict sysDict,@PathVariable String id){
        //设置主键值
        sysDict.setId(id);
        //调用SysDictService实现修改SysDict
        sysDictService.update(sysDict);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysDict数据
     * @param sysDict
     * @return
     */
    @ApiOperation(value = "SysDict添加",notes = "添加SysDict方法详情",tags = {"SysDictController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysDict对象",value = "传入JSON数据",required = true) SysDict sysDict){
        //调用SysDictService实现添加SysDict
        sysDictService.add(sysDict);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysDict数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDict根据ID查询",notes = "根据ID查询SysDict方法详情",tags = {"SysDictController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysDict> findById(@PathVariable String id){
        //调用SysDictService实现根据主键查询SysDict
        SysDict sysDict = sysDictService.findById(id);
        return new Result<SysDict>(true,StatusCode.OK,"查询成功",sysDict);
    }

    /***
     * 查询SysDict全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysDict",notes = "查询所SysDict有方法详情",tags = {"SysDictController"})
    @GetMapping
    public Result<List<SysDict>> findAll(){
        //调用SysDictService实现查询所有SysDict
        List<SysDict> list = sysDictService.findAll();
        return new Result<List<SysDict>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
