package com.jeekite.sys.controller;
import com.jeekite.sys.entity.SysUserRole;
import com.jeekite.sys.service.SysUserRoleService;
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
@Api(value = "SysUserRoleController")
@RestController
@RequestMapping("/sysUserRole")
@CrossOrigin
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /***
     * SysUserRole分页条件搜索实现
     * @param sysUserRole
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysUserRole条件分页查询",notes = "分页条件查询SysUserRole方法详情",tags = {"SysUserRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysUserRole对象",value = "传入JSON数据",required = false) SysUserRole sysUserRole, @PathVariable  int page, @PathVariable  int size){
        //调用SysUserRoleService实现分页条件查询SysUserRole
        PageInfo<SysUserRole> pageInfo = sysUserRoleService.findPage(sysUserRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysUserRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysUserRole分页查询",notes = "分页查询SysUserRole方法详情",tags = {"SysUserRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysUserRoleService实现分页查询SysUserRole
        PageInfo<SysUserRole> pageInfo = sysUserRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysUserRole
     * @return
     */
    @ApiOperation(value = "SysUserRole条件查询",notes = "条件查询SysUserRole方法详情",tags = {"SysUserRoleController"})
    @PostMapping(value = "/search" )
    public Result<List<SysUserRole>> findList(@RequestBody(required = false) @ApiParam(name = "SysUserRole对象",value = "传入JSON数据",required = false) SysUserRole sysUserRole){
        //调用SysUserRoleService实现条件查询SysUserRole
        List<SysUserRole> list = sysUserRoleService.findList(sysUserRole);
        return new Result<List<SysUserRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysUserRole根据ID删除",notes = "根据ID删除SysUserRole方法详情",tags = {"SysUserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysUserRoleService实现根据主键删除
        sysUserRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysUserRole数据
     * @param sysUserRole
     * @param id
     * @return
     */
    @ApiOperation(value = "SysUserRole根据ID修改",notes = "根据ID修改SysUserRole方法详情",tags = {"SysUserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysUserRole对象",value = "传入JSON数据",required = false) SysUserRole sysUserRole,@PathVariable String id){
        //设置主键值
        sysUserRole.setId(id);
        //调用SysUserRoleService实现修改SysUserRole
        sysUserRoleService.update(sysUserRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysUserRole数据
     * @param sysUserRole
     * @return
     */
    @ApiOperation(value = "SysUserRole添加",notes = "添加SysUserRole方法详情",tags = {"SysUserRoleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysUserRole对象",value = "传入JSON数据",required = true) SysUserRole sysUserRole){
        //调用SysUserRoleService实现添加SysUserRole
        sysUserRoleService.add(sysUserRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysUserRole数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysUserRole根据ID查询",notes = "根据ID查询SysUserRole方法详情",tags = {"SysUserRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysUserRole> findById(@PathVariable String id){
        //调用SysUserRoleService实现根据主键查询SysUserRole
        SysUserRole sysUserRole = sysUserRoleService.findById(id);
        return new Result<SysUserRole>(true,StatusCode.OK,"查询成功",sysUserRole);
    }

    /***
     * 查询SysUserRole全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysUserRole",notes = "查询所SysUserRole有方法详情",tags = {"SysUserRoleController"})
    @GetMapping
    public Result<List<SysUserRole>> findAll(){
        //调用SysUserRoleService实现查询所有SysUserRole
        List<SysUserRole> list = sysUserRoleService.findAll();
        return new Result<List<SysUserRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
