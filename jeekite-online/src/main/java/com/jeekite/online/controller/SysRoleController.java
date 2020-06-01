package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysRole;
import com.jeekite.online.service.SysRoleService;
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
@Api(value = "SysRoleController")
@RestController
@RequestMapping("/sysRole")
@CrossOrigin
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /***
     * SysRole分页条件搜索实现
     * @param sysRole
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysRole条件分页查询",notes = "分页条件查询SysRole方法详情",tags = {"SysRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysRole对象",value = "传入JSON数据",required = false) SysRole sysRole, @PathVariable  int page, @PathVariable  int size){
        //调用SysRoleService实现分页条件查询SysRole
        PageInfo<SysRole> pageInfo = sysRoleService.findPage(sysRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysRole分页查询",notes = "分页查询SysRole方法详情",tags = {"SysRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysRoleService实现分页查询SysRole
        PageInfo<SysRole> pageInfo = sysRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysRole
     * @return
     */
    @ApiOperation(value = "SysRole条件查询",notes = "条件查询SysRole方法详情",tags = {"SysRoleController"})
    @PostMapping(value = "/search" )
    public Result<List<SysRole>> findList(@RequestBody(required = false) @ApiParam(name = "SysRole对象",value = "传入JSON数据",required = false) SysRole sysRole){
        //调用SysRoleService实现条件查询SysRole
        List<SysRole> list = sysRoleService.findList(sysRole);
        return new Result<List<SysRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysRole根据ID删除",notes = "根据ID删除SysRole方法详情",tags = {"SysRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysRoleService实现根据主键删除
        sysRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysRole数据
     * @param sysRole
     * @param id
     * @return
     */
    @ApiOperation(value = "SysRole根据ID修改",notes = "根据ID修改SysRole方法详情",tags = {"SysRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysRole对象",value = "传入JSON数据",required = false) SysRole sysRole,@PathVariable String id){
        //设置主键值
        sysRole.setId(id);
        //调用SysRoleService实现修改SysRole
        sysRoleService.update(sysRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysRole数据
     * @param sysRole
     * @return
     */
    @ApiOperation(value = "SysRole添加",notes = "添加SysRole方法详情",tags = {"SysRoleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysRole对象",value = "传入JSON数据",required = true) SysRole sysRole){
        //调用SysRoleService实现添加SysRole
        sysRoleService.add(sysRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysRole数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysRole根据ID查询",notes = "根据ID查询SysRole方法详情",tags = {"SysRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysRole> findById(@PathVariable String id){
        //调用SysRoleService实现根据主键查询SysRole
        SysRole sysRole = sysRoleService.findById(id);
        return new Result<SysRole>(true,StatusCode.OK,"查询成功",sysRole);
    }

    /***
     * 查询SysRole全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysRole",notes = "查询所SysRole有方法详情",tags = {"SysRoleController"})
    @GetMapping
    public Result<List<SysRole>> findAll(){
        //调用SysRoleService实现查询所有SysRole
        List<SysRole> list = sysRoleService.findAll();
        return new Result<List<SysRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
