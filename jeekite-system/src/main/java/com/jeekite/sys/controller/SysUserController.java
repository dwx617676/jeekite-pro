package com.jeekite.sys.controller;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import com.jeekite.common.constant.CommonConstant;
import com.jeekite.common.result.SysLoginModel;
import com.jeekite.common.util.MD5Util;
import com.jeekite.common.util.RandImageUtil;
import com.jeekite.common.utils.IdWorker;
import com.jeekite.common.utils.JwtUtil;
import com.jeekite.common.utils.oConvertUtils;
import com.jeekite.sys.entity.*;
import com.jeekite.sys.service.*;
import com.github.pagehelper.PageInfo;
import com.jeekite.common.result.Result;
import com.jeekite.common.result.StatusCode;
import com.jeekite.sys.util.RedisUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/****
 * @Author:dudianlong
 * @Description:
 * @Date 2020/5/14 0:18
 *****/
@Api(value = "SysUserController")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class SysUserController {
    private static final String BASE_CHECK_CODES = "qwertyuiplkjhgfdsazxcvbnmQWERTYUPLKJHGFDSAZXCVBNM1234567890";
      @Autowired
      private RedisUtil redisUtil;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ISysLogService logService;

    @Autowired
     private ISysDepartService sysDepartService;
    @Autowired
    private ISysBaseAPI sysBaseAPI;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private IdWorker idWorker;
    @ApiOperation("获取验证码")
    @GetMapping(value = "/randomImage/{key}")
    public Result<String> randomImage(HttpServletResponse response, @PathVariable String key){
        Result<String> res = new Result<String>();
        try {
            String code = RandomUtil.randomString(BASE_CHECK_CODES,4);
            String lowerCaseCode = code.toLowerCase();
            String realKey = MD5Util.MD5Encode(lowerCaseCode+key, "utf-8");
           redisUtil.set(realKey, lowerCaseCode, 60);
           // redisTemplate.opsForSet().add(realKey,lowerCaseCode,60);
            String base64 = RandImageUtil.generate(code);
            res.setSuccess(true);
            res.setResult(base64);
        } catch (Exception e) {
            res.error500("获取验证码出错"+e.getMessage());
            e.printStackTrace();
        }
        return res;
    }


    @ApiOperation("登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<JSONObject> login(@RequestBody SysLoginModel sysLoginModel){
        Result<JSONObject> result = new Result<JSONObject>();
        String username = sysLoginModel.getUsername();
        String password = sysLoginModel.getPassword();
        //update-begin--Author:scott  Date:20190805 for：暂时注释掉密码加密逻辑，有点问题
        //前端密码加密，后端进行密码解密
        //password = AesEncryptUtil.desEncrypt(sysLoginModel.getPassword().replaceAll("%2B", "\\+")).trim();//密码解密
        //update-begin--Author:scott  Date:20190805 for：暂时注释掉密码加密逻辑，有点问题

        //update-begin-author:taoyan date:20190828 for:校验验证码
        String captcha = sysLoginModel.getCaptcha();
        if(captcha==null){
            result.error500("验证码无效");
            return result;
        }
        String lowerCaseCaptcha = captcha.toLowerCase();
        String realKey = MD5Util.MD5Encode(lowerCaseCaptcha+sysLoginModel.getCheckKey(), "utf-8");
        Object checkCode = redisUtil.get(realKey);
        if(checkCode==null || !checkCode.equals(lowerCaseCaptcha)) {
            result.error500("验证码错误");
            return result;
        }
        //update-end-author:taoyan date:20190828 for:校验验证码

        //1. 校验用户是否有效
        SysUser sysUser = sysUserService.getUserByName(username);
        result = sysUserService.checkUserIsEffective(sysUser);
        if(!result.isSuccess()) {
            return result;
        }
        boolean matches = encoder.matches(password, sysUser.getPassword());
        if(sysUser != null && !matches) {
            result.error500("用户名或密码错误");
            return result;
        }
        //用户登录信息
        userInfo(sysUser, result);
       sysBaseAPI.addLog("用户名: " + username + ",登录成功！", CommonConstant.LOG_TYPE_1, null);

        return result;
    }

    private Result<JSONObject> userInfo(SysUser sysUser, Result<JSONObject> result) {
        String username = sysUser.getUsername();
        // 生成token
    //    String token = JwtUtil.sign(username, syspassword);
        SysUserRole sysUserRole=new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        List<SysUserRole> list = sysUserRoleService.findList(sysUserRole);
        List<SysRole> roleList=new ArrayList<>();
        if(list!=null&&list.size()!=0){
            for (SysUserRole userRole : list) {
                String roleId = sysUserRole.getRoleId();
                SysRole role = roleService.findById(roleId);
                roleList.add(role);
            }
        }

        String token = jwtUtil.createJWT(sysUser.getId(), username, roleList.toString());
        // 设置token缓存有效时间
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
        redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, 60000);

        // 获取用户部门信息
        JSONObject obj = new JSONObject();
        List<SysDepart> departs = sysDepartService.queryUserDeparts(sysUser.getId());
        obj.put("departs", departs);
        if (departs == null || departs.size() == 0) {
            obj.put("multi_depart", 0);
        } else if (departs.size() == 1) {
            sysUserService.updateUserDepart(username, departs.get(0).getOrgCode());
            obj.put("multi_depart", 1);
        } else {
            obj.put("multi_depart", 2);
        }
        obj.put("token", token);
        obj.put("userInfo", sysUser);
        //obj.put("sysAllDictItems", sysDictService.queryAllDictItems());
        result.setResult(obj);
        result.success("登录成功");
        return result;
    }

    @ApiOperation("登录信息")
    @GetMapping("loginfo")
    public Result<JSONObject> loginfo() {
        Result<JSONObject> result = new Result<JSONObject>();
        JSONObject obj = new JSONObject();
        //update-begin--Author:zhangweijian  Date:20190428 for：传入开始时间，结束时间参数
        // 获取一天的开始和结束时间
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dayStart = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date dayEnd = calendar.getTime();
        // 获取系统访问记录
        Long totalVisitCount = logService.findTotalVisitCount();
        obj.put("totalVisitCount", totalVisitCount);
        Long todayVisitCount = logService.findTodayVisitCount(dayStart,dayEnd);
        obj.put("todayVisitCount", todayVisitCount);
        Long todayIp = logService.findTodayIp(dayStart,dayEnd);
        //update-end--Author:zhangweijian  Date:20190428 for：传入开始时间，结束时间参数
        obj.put("todayIp", todayIp);
        result.setResult(obj);
        result.success("登录成功");
        return result;
    }

    /**
     * 获取访问量
     * @return
     */
    @ApiOperation("获取访问量")
    @GetMapping("visitInfo")
    public Result<List<Map<String,Object>>> visitInfo() {
        Result<List<Map<String,Object>>> result = new Result<List<Map<String,Object>>>();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date dayEnd = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date dayStart = calendar.getTime();
        List<Map<String,Object>> list = logService.findVisitCount(dayStart, dayEnd);
        result.setResult(oConvertUtils.toLowerCasePageList(list));
        return result;
    }


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
        sysUser.setId( idWorker.nextId()+"");
        String salt = oConvertUtils.randomGen(8);
        sysUser.setSalt(salt);
        sysUser.setPassword(encoder.encode(sysUser.getPassword()));
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
