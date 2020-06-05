package com.jeekite.sys.service.impl;
import cn.hutool.json.JSONObject;
import com.jeekite.common.constant.CommonConstant;
import com.jeekite.common.result.Result;
import com.jeekite.sys.mapper.SysUserMapper;
import com.jeekite.sys.entity.SysUser;
import com.jeekite.sys.service.ISysBaseAPI;
import com.jeekite.sys.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysUser业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

   @Autowired
   private ISysBaseAPI sysBaseAPI;
    /**
     * SysUser条件+分页查询
     * @param sysUser 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysUser> findPage(SysUser sysUser, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysUser);
        //执行搜索
        return new PageInfo<SysUser>(sysUserMapper.selectByExample(example));
    }

    /**
     * SysUser分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysUser> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysUser>(sysUserMapper.selectAll());
    }

    /**
     * SysUser条件查询
     * @param sysUser
     * @return
     */
    @Override
    public List<SysUser> findList(SysUser sysUser){
        //构建查询条件
        Example example = createExample(sysUser);
        //根据构建的条件查询数据
        return sysUserMapper.selectByExample(example);
    }


    /**
     * SysUser构建查询对象
     * @param sysUser
     * @return
     */
    public Example createExample(SysUser sysUser){
        Example example=new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysUser!=null){
            // 主键id
            if(!StringUtils.isEmpty(sysUser.getId())){
                    criteria.andEqualTo("id",sysUser.getId());
            }
            // 登录账号
            if(!StringUtils.isEmpty(sysUser.getUsername())){
                    criteria.andLike("username","%"+sysUser.getUsername()+"%");
            }
            // 真实姓名
            if(!StringUtils.isEmpty(sysUser.getRealname())){
                    criteria.andLike("realname","%"+sysUser.getRealname()+"%");
            }
            // 密码
            if(!StringUtils.isEmpty(sysUser.getPassword())){
                    criteria.andEqualTo("password",sysUser.getPassword());
            }
            // md5密码盐
            if(!StringUtils.isEmpty(sysUser.getSalt())){
                    criteria.andEqualTo("salt",sysUser.getSalt());
            }
            // 头像
            if(!StringUtils.isEmpty(sysUser.getAvatar())){
                    criteria.andEqualTo("avatar",sysUser.getAvatar());
            }
            // 生日
            if(!StringUtils.isEmpty(sysUser.getBirthday())){
                    criteria.andEqualTo("birthday",sysUser.getBirthday());
            }
            // 性别(0-默认未知,1-男,2-女)
            if(!StringUtils.isEmpty(sysUser.getSex())){
                    criteria.andEqualTo("sex",sysUser.getSex());
            }
            // 电子邮件
            if(!StringUtils.isEmpty(sysUser.getEmail())){
                    criteria.andEqualTo("email",sysUser.getEmail());
            }
            // 电话
            if(!StringUtils.isEmpty(sysUser.getPhone())){
                    criteria.andEqualTo("phone",sysUser.getPhone());
            }
            // 机构编码
            if(!StringUtils.isEmpty(sysUser.getOrgCode())){
                    criteria.andEqualTo("orgCode",sysUser.getOrgCode());
            }
            // 性别(1-正常,2-冻结)
            if(!StringUtils.isEmpty(sysUser.getStatus())){
                    criteria.andEqualTo("status",sysUser.getStatus());
            }
            // 删除状态(0-正常,1-已删除)
            if(!StringUtils.isEmpty(sysUser.getDelFlag())){
                    criteria.andEqualTo("delFlag",sysUser.getDelFlag());
            }
            // 第三方登录的唯一标识
            if(!StringUtils.isEmpty(sysUser.getThirdId())){
                    criteria.andEqualTo("thirdId",sysUser.getThirdId());
            }
            // 第三方类型
            if(!StringUtils.isEmpty(sysUser.getThirdType())){
                    criteria.andEqualTo("thirdType",sysUser.getThirdType());
            }
            // 同步工作流引擎(1-同步,0-不同步)
            if(!StringUtils.isEmpty(sysUser.getActivitiSync())){
                    criteria.andEqualTo("activitiSync",sysUser.getActivitiSync());
            }
            // 工号，唯一键
            if(!StringUtils.isEmpty(sysUser.getWorkNo())){
                    criteria.andEqualTo("workNo",sysUser.getWorkNo());
            }
            // 职务，关联职务表
            if(!StringUtils.isEmpty(sysUser.getPost())){
                    criteria.andEqualTo("post",sysUser.getPost());
            }
            // 座机号
            if(!StringUtils.isEmpty(sysUser.getTelephone())){
                    criteria.andEqualTo("telephone",sysUser.getTelephone());
            }
            // 创建人
            if(!StringUtils.isEmpty(sysUser.getCreateBy())){
                    criteria.andEqualTo("createBy",sysUser.getCreateBy());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysUser.getCreateTime())){
                    criteria.andEqualTo("createTime",sysUser.getCreateTime());
            }
            // 更新人
            if(!StringUtils.isEmpty(sysUser.getUpdateBy())){
                    criteria.andEqualTo("updateBy",sysUser.getUpdateBy());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sysUser.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysUser.getUpdateTime());
            }
            // 身份（1普通成员 2上级）
            if(!StringUtils.isEmpty(sysUser.getUserIdentity())){
                    criteria.andEqualTo("userIdentity",sysUser.getUserIdentity());
            }
            // 负责部门
            if(!StringUtils.isEmpty(sysUser.getDepartIds())){
                    criteria.andEqualTo("departIds",sysUser.getDepartIds());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysUser
     * @param sysUser
     */
    @Override
    public void update(SysUser sysUser){
        sysUserMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 增加SysUser
     * @param sysUser
     */
    @Override
    public void add(SysUser sysUser){
        sysUserMapper.insert(sysUser);
    }

    /**
     * 根据ID查询SysUser
     * @param id
     * @return
     */
    @Override
    public SysUser findById(String id){
        return  sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysUser全部数据
     * @return
     */
    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public SysUser getUserByName(String username) {
        SysUser user=new SysUser();
        user.setUsername(username);
        return     sysUserMapper.selectOne(user);

    }

    @Override
    public Result<JSONObject> checkUserIsEffective(SysUser sysUser) {
        Result<JSONObject> result = new Result<JSONObject>();
        //情况1：根据用户信息查询，该用户不存在
        if (sysUser == null) {
            result.error500("该用户不存在，请注册");
            sysBaseAPI.addLog("用户登录失败，用户不存在！", CommonConstant.LOG_TYPE_1, null);
            return result;
        }
        //情况2：根据用户信息查询，该用户已注销
        if (CommonConstant.DEL_FLAG_1.toString().equals(sysUser.getDelFlag())) {
            sysBaseAPI.addLog("用户登录失败，用户名:" + sysUser.getUsername() + "已注销！", CommonConstant.LOG_TYPE_1, null);
            result.error500("该用户已注销");
            return result;
        }
        //情况3：根据用户信息查询，该用户已冻结
        if (CommonConstant.USER_FREEZE.equals(sysUser.getStatus())) {
            sysBaseAPI.addLog("用户登录失败，用户名:" + sysUser.getUsername() + "已冻结！", CommonConstant.LOG_TYPE_1, null);
            result.error500("该用户已冻结");
            return result;
        }
        return result;
    }

    @Override
    public void updateUserDepart(String username, String orgCode) {

    }
}
