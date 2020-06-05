package com.jeekite.sys.controller;
import com.jeekite.sys.entity.SysPermission;
import com.jeekite.sys.service.SysPermissionService;
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
@Api(value = "SysPermissionController")
@RestController
@RequestMapping("/sysPermission")
@CrossOrigin
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    /***
     * SysPermission分页条件搜索实现
     * @param sysPermission
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysPermission条件分页查询",notes = "分页条件查询SysPermission方法详情",tags = {"SysPermissionController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysPermission对象",value = "传入JSON数据",required = false) SysPermission sysPermission, @PathVariable  int page, @PathVariable  int size){
        //调用SysPermissionService实现分页条件查询SysPermission
        PageInfo<SysPermission> pageInfo = sysPermissionService.findPage(sysPermission, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysPermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysPermission分页查询",notes = "分页查询SysPermission方法详情",tags = {"SysPermissionController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysPermissionService实现分页查询SysPermission
        PageInfo<SysPermission> pageInfo = sysPermissionService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysPermission
     * @return
     */
    @ApiOperation(value = "SysPermission条件查询",notes = "条件查询SysPermission方法详情",tags = {"SysPermissionController"})
    @PostMapping(value = "/search" )
    public Result<List<SysPermission>> findList(@RequestBody(required = false) @ApiParam(name = "SysPermission对象",value = "传入JSON数据",required = false) SysPermission sysPermission){
        //调用SysPermissionService实现条件查询SysPermission
        List<SysPermission> list = sysPermissionService.findList(sysPermission);
        return new Result<List<SysPermission>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysPermission根据ID删除",notes = "根据ID删除SysPermission方法详情",tags = {"SysPermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysPermissionService实现根据主键删除
        sysPermissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysPermission数据
     * @param sysPermission
     * @param id
     * @return
     */
    @ApiOperation(value = "SysPermission根据ID修改",notes = "根据ID修改SysPermission方法详情",tags = {"SysPermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysPermission对象",value = "传入JSON数据",required = false) SysPermission sysPermission,@PathVariable String id){
        //设置主键值
        sysPermission.setId(id);
        //调用SysPermissionService实现修改SysPermission
        sysPermissionService.update(sysPermission);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysPermission数据
     * @param sysPermission
     * @return
     */
    @ApiOperation(value = "SysPermission添加",notes = "添加SysPermission方法详情",tags = {"SysPermissionController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysPermission对象",value = "传入JSON数据",required = true) SysPermission sysPermission){
        //调用SysPermissionService实现添加SysPermission
        sysPermissionService.add(sysPermission);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysPermission数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysPermission根据ID查询",notes = "根据ID查询SysPermission方法详情",tags = {"SysPermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysPermission> findById(@PathVariable String id){
        //调用SysPermissionService实现根据主键查询SysPermission
        SysPermission sysPermission = sysPermissionService.findById(id);
        return new Result<SysPermission>(true,StatusCode.OK,"查询成功",sysPermission);
    }

    /***
     * 查询SysPermission全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysPermission",notes = "查询所SysPermission有方法详情",tags = {"SysPermissionController"})
    @GetMapping
    public Result<List<SysPermission>> findAll(){
        //调用SysPermissionService实现查询所有SysPermission
        List<SysPermission> list = sysPermissionService.findAll();
        return new Result<List<SysPermission>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
