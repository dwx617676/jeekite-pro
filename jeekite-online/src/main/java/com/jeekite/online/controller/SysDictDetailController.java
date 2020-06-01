package com.jeekite.online.controller;
import com.jeekite.online.pojo.SysDictDetail;
import com.jeekite.online.service.SysDictDetailService;
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
@Api(value = "SysDictDetailController")
@RestController
@RequestMapping("/sysDictDetail")
@CrossOrigin
public class SysDictDetailController {

    @Autowired
    private SysDictDetailService sysDictDetailService;

    /***
     * SysDictDetail分页条件搜索实现
     * @param sysDictDetail
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SysDictDetail条件分页查询",notes = "分页条件查询SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SysDictDetail对象",value = "传入JSON数据",required = false) SysDictDetail sysDictDetail, @PathVariable  int page, @PathVariable  int size){
        //调用SysDictDetailService实现分页条件查询SysDictDetail
        PageInfo<SysDictDetail> pageInfo = sysDictDetailService.findPage(sysDictDetail, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysDictDetail分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SysDictDetail分页查询",notes = "分页查询SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysDictDetailService实现分页查询SysDictDetail
        PageInfo<SysDictDetail> pageInfo = sysDictDetailService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysDictDetail
     * @return
     */
    @ApiOperation(value = "SysDictDetail条件查询",notes = "条件查询SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @PostMapping(value = "/search" )
    public Result<List<SysDictDetail>> findList(@RequestBody(required = false) @ApiParam(name = "SysDictDetail对象",value = "传入JSON数据",required = false) SysDictDetail sysDictDetail){
        //调用SysDictDetailService实现条件查询SysDictDetail
        List<SysDictDetail> list = sysDictDetailService.findList(sysDictDetail);
        return new Result<List<SysDictDetail>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictDetail根据ID删除",notes = "根据ID删除SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用SysDictDetailService实现根据主键删除
        sysDictDetailService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysDictDetail数据
     * @param sysDictDetail
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictDetail根据ID修改",notes = "根据ID修改SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "SysDictDetail对象",value = "传入JSON数据",required = false) SysDictDetail sysDictDetail,@PathVariable String id){
        //设置主键值
        sysDictDetail.setId(id);
        //调用SysDictDetailService实现修改SysDictDetail
        sysDictDetailService.update(sysDictDetail);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysDictDetail数据
     * @param sysDictDetail
     * @return
     */
    @ApiOperation(value = "SysDictDetail添加",notes = "添加SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "SysDictDetail对象",value = "传入JSON数据",required = true) SysDictDetail sysDictDetail){
        //调用SysDictDetailService实现添加SysDictDetail
        sysDictDetailService.add(sysDictDetail);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysDictDetail数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SysDictDetail根据ID查询",notes = "根据ID查询SysDictDetail方法详情",tags = {"SysDictDetailController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<SysDictDetail> findById(@PathVariable String id){
        //调用SysDictDetailService实现根据主键查询SysDictDetail
        SysDictDetail sysDictDetail = sysDictDetailService.findById(id);
        return new Result<SysDictDetail>(true,StatusCode.OK,"查询成功",sysDictDetail);
    }

    /***
     * 查询SysDictDetail全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SysDictDetail",notes = "查询所SysDictDetail有方法详情",tags = {"SysDictDetailController"})
    @GetMapping
    public Result<List<SysDictDetail>> findAll(){
        //调用SysDictDetailService实现查询所有SysDictDetail
        List<SysDictDetail> list = sysDictDetailService.findAll();
        return new Result<List<SysDictDetail>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
