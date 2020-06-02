package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysDept;
import com.jeekite.online.service.SysDeptService;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.common.result.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@Api(value = "SysDeptController")
@RestController
@RequestMapping("/sysDept")
@CrossOrigin
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /***
     * SysDept分页条件搜索实现
     * @param sysDept
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysDept条件分页查询",notes = "分页条件查询SysDept方法详情",tags = {"SysDeptController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysDept对象",value = "传入JSON数据",required = false) SysDept sysDept, @PathVariable  int page, @PathVariable  int size){
        //调用SysDeptService实现分页条件查询SysDept
        PageInfo<SysDept> pageInfo = sysDeptService.findPage(sysDept, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysDept分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysDept分页查询",notes = "分页查询SysDept方法详情",tags = {"SysDeptController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysDeptService实现分页查询SysDept
        PageInfo<SysDept> pageInfo = sysDeptService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysDept
     * @return
     */
    @ApiOperation(value = "SysDept条件查询",notes = "条件查询SysDept方法详情",tags = {"SysDeptController"})
    @PostMapping(value = "/search" )
    public Result<List<SysDept>> findList(@RequestBody(required = false) @ApiParam(name = "SysDept对象",value = "传入JSON数据",required = false) SysDept sysDept){
        //调用SysDeptService实现条件查询SysDept
        List<SysDept> list = sysDeptService.findList(sysDept);
        return new Result<List<SysDept>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDept根据ID删除",notes = "根据ID删除SysDept方法详情",tags = {"SysDeptController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysDeptService实现根据主键删除
        sysDeptService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysDept数据
     * @param sysDept
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDept根据ID修改",notes = "根据ID修改SysDept方法详情",tags = {"SysDeptController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysDept对象",value = "传入JSON数据",required = false) SysDept sysDept,@PathVariable String id){
        //设置主键值
        sysDept.setId(id);
        //调用SysDeptService实现修改SysDept
        sysDeptService.update(sysDept);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysDept数据
     * @param sysDept
     * @return
     */
    @ApiOperation(value = "SysDept添加",notes = "添加SysDept方法详情",tags = {"SysDeptController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysDept对象",value = "传入JSON数据",required = true) SysDept sysDept){
        //调用SysDeptService实现添加SysDept
        sysDeptService.add(sysDept);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysDept数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDept根据ID查询",notes = "根据ID查询SysDept方法详情",tags = {"SysDeptController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysDept> findById(@PathVariable String id){
        //调用SysDeptService实现根据主键查询SysDept
        SysDept sysDept = sysDeptService.findById(id);
        return new Result<SysDept>(true,StatusCode.OK,"查询成功",sysDept);
    }

    /***
     * 查询SysDept全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysDept",notes = "查询所SysDept有方法详情",tags = {"SysDeptController"})
    @GetMapping
    public Result<List<SysDept>> findAll(){
        //调用SysDeptService实现查询所有SysDept
        List<SysDept> list = sysDeptService.findAll();
        return new Result<List<SysDept>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
