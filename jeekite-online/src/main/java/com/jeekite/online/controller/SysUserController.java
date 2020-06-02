package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysUser;
import com.jeekite.online.service.SysUserService;
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
@Api(value = "SysUserController")
@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /***
     * SysUser分页条件搜索实现
     * @param sysUser
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysUser条件分页查询",notes = "分页条件查询SysUser方法详情",tags = {"SysUserController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysUser对象",value = "传入JSON数据",required = false) SysUser sysUser, @PathVariable  int page, @PathVariable  int size){
        //调用SysUserService实现分页条件查询SysUser
        PageInfo<SysUser> pageInfo = sysUserService.findPage(sysUser, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysUser分页查询",notes = "分页查询SysUser方法详情",tags = {"SysUserController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysUserService实现分页查询SysUser
        PageInfo<SysUser> pageInfo = sysUserService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysUser
     * @return
     */
    @ApiOperation(value = "SysUser条件查询",notes = "条件查询SysUser方法详情",tags = {"SysUserController"})
    @PostMapping(value = "/search" )
    public Result<List<SysUser>> findList(@RequestBody(required = false) @ApiParam(name = "SysUser对象",value = "传入JSON数据",required = false) SysUser sysUser){
        //调用SysUserService实现条件查询SysUser
        List<SysUser> list = sysUserService.findList(sysUser);
        return new Result<List<SysUser>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysUser根据ID删除",notes = "根据ID删除SysUser方法详情",tags = {"SysUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysUserService实现根据主键删除
        sysUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysUser数据
     * @param sysUser
     * @param id
     * @return
     */
    @ApiOperation(value = "SysUser根据ID修改",notes = "根据ID修改SysUser方法详情",tags = {"SysUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysUser对象",value = "传入JSON数据",required = false) SysUser sysUser,@PathVariable String id){
        //设置主键值
        sysUser.setId(id);
        //调用SysUserService实现修改SysUser
        sysUserService.update(sysUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysUser数据
     * @param sysUser
     * @return
     */
    @ApiOperation(value = "SysUser添加",notes = "添加SysUser方法详情",tags = {"SysUserController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysUser对象",value = "传入JSON数据",required = true) SysUser sysUser){
        //调用SysUserService实现添加SysUser
        sysUserService.add(sysUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysUser数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysUser根据ID查询",notes = "根据ID查询SysUser方法详情",tags = {"SysUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysUser> findById(@PathVariable String id){
        //调用SysUserService实现根据主键查询SysUser
        SysUser sysUser = sysUserService.findById(id);
        return new Result<SysUser>(true,StatusCode.OK,"查询成功",sysUser);
    }

    /***
     * 查询SysUser全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysUser",notes = "查询所SysUser有方法详情",tags = {"SysUserController"})
    @GetMapping
    public Result<List<SysUser>> findAll(){
        //调用SysUserService实现查询所有SysUser
        List<SysUser> list = sysUserService.findAll();
        return new Result<List<SysUser>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
