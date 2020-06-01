package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysRolePermission;
import com.jeekite.online.service.SysRolePermissionService;
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
@Api(value = "SysRolePermissionController")
@RestController
@RequestMapping("/sysRolePermission")
@CrossOrigin
public class SysRolePermissionController {

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /***
     * SysRolePermission分页条件搜索实现
     * @param sysRolePermission
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysRolePermission条件分页查询",notes = "分页条件查询SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysRolePermission对象",value = "传入JSON数据",required = false) SysRolePermission sysRolePermission, @PathVariable  int page, @PathVariable  int size){
        //调用SysRolePermissionService实现分页条件查询SysRolePermission
        PageInfo<SysRolePermission> pageInfo = sysRolePermissionService.findPage(sysRolePermission, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysRolePermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysRolePermission分页查询",notes = "分页查询SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysRolePermissionService实现分页查询SysRolePermission
        PageInfo<SysRolePermission> pageInfo = sysRolePermissionService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysRolePermission
     * @return
     */
    @ApiOperation(value = "SysRolePermission条件查询",notes = "条件查询SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @PostMapping(value = "/search" )
    public Result<List<SysRolePermission>> findList(@RequestBody(required = false) @ApiParam(name = "SysRolePermission对象",value = "传入JSON数据",required = false) SysRolePermission sysRolePermission){
        //调用SysRolePermissionService实现条件查询SysRolePermission
        List<SysRolePermission> list = sysRolePermissionService.findList(sysRolePermission);
        return new Result<List<SysRolePermission>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysRolePermission根据ID删除",notes = "根据ID删除SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysRolePermissionService实现根据主键删除
        sysRolePermissionService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysRolePermission数据
     * @param sysRolePermission
     * @param id
     * @return
     */
    @ApiOperation(value = "SysRolePermission根据ID修改",notes = "根据ID修改SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysRolePermission对象",value = "传入JSON数据",required = false) SysRolePermission sysRolePermission,@PathVariable String id){
        //设置主键值
        sysRolePermission.setId(id);
        //调用SysRolePermissionService实现修改SysRolePermission
        sysRolePermissionService.update(sysRolePermission);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysRolePermission数据
     * @param sysRolePermission
     * @return
     */
    @ApiOperation(value = "SysRolePermission添加",notes = "添加SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysRolePermission对象",value = "传入JSON数据",required = true) SysRolePermission sysRolePermission){
        //调用SysRolePermissionService实现添加SysRolePermission
        sysRolePermissionService.add(sysRolePermission);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysRolePermission数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysRolePermission根据ID查询",notes = "根据ID查询SysRolePermission方法详情",tags = {"SysRolePermissionController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysRolePermission> findById(@PathVariable String id){
        //调用SysRolePermissionService实现根据主键查询SysRolePermission
        SysRolePermission sysRolePermission = sysRolePermissionService.findById(id);
        return new Result<SysRolePermission>(true,StatusCode.OK,"查询成功",sysRolePermission);
    }

    /***
     * 查询SysRolePermission全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysRolePermission",notes = "查询所SysRolePermission有方法详情",tags = {"SysRolePermissionController"})
    @GetMapping
    public Result<List<SysRolePermission>> findAll(){
        //调用SysRolePermissionService实现查询所有SysRolePermission
        List<SysRolePermission> list = sysRolePermissionService.findAll();
        return new Result<List<SysRolePermission>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
