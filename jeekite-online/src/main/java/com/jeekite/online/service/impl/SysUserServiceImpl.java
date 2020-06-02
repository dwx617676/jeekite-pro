package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysUserMapper;
import com.jeekite.online.pojo.SysUser;
import com.jeekite.online.service.SysUserService;
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
            // 用户id
            if(!StringUtils.isEmpty(sysUser.getId())){
                    criteria.andEqualTo("id",sysUser.getId());
            }
            // 账户名称
            if(!StringUtils.isEmpty(sysUser.getUsername())){
                    criteria.andLike("username","%"+sysUser.getUsername()+"%");
            }
            // 加密盐值
            if(!StringUtils.isEmpty(sysUser.getSalt())){
                    criteria.andEqualTo("salt",sysUser.getSalt());
            }
            // 用户密码密文
            if(!StringUtils.isEmpty(sysUser.getPassword())){
                    criteria.andEqualTo("password",sysUser.getPassword());
            }
            // 手机号码
            if(!StringUtils.isEmpty(sysUser.getPhone())){
                    criteria.andEqualTo("phone",sysUser.getPhone());
            }
            // 部门id
            if(!StringUtils.isEmpty(sysUser.getDeptId())){
                    criteria.andEqualTo("deptId",sysUser.getDeptId());
            }
            // 真实名称
            if(!StringUtils.isEmpty(sysUser.getRealName())){
                    criteria.andEqualTo("realName",sysUser.getRealName());
            }
            // 昵称
            if(!StringUtils.isEmpty(sysUser.getNickName())){
                    criteria.andEqualTo("nickName",sysUser.getNickName());
            }
            // 邮箱(唯一)
            if(!StringUtils.isEmpty(sysUser.getEmail())){
                    criteria.andEqualTo("email",sysUser.getEmail());
            }
            // 账户状态(1.正常 2.锁定 )
            if(!StringUtils.isEmpty(sysUser.getStatus())){
                    criteria.andEqualTo("status",sysUser.getStatus());
            }
            // 性别(1.男 2.女)
            if(!StringUtils.isEmpty(sysUser.getSex())){
                    criteria.andEqualTo("sex",sysUser.getSex());
            }
            // 是否删除(1未删除；0已删除)
            if(!StringUtils.isEmpty(sysUser.getDeleted())){
                    criteria.andEqualTo("deleted",sysUser.getDeleted());
            }
            // 创建人
            if(!StringUtils.isEmpty(sysUser.getCreateId())){
                    criteria.andEqualTo("createId",sysUser.getCreateId());
            }
            // 更新人
            if(!StringUtils.isEmpty(sysUser.getUpdateId())){
                    criteria.andEqualTo("updateId",sysUser.getUpdateId());
            }
            // 创建来源(1.web 2.android 3.ios )
            if(!StringUtils.isEmpty(sysUser.getCreateWhere())){
                    criteria.andEqualTo("createWhere",sysUser.getCreateWhere());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysUser.getCreateTime())){
                    criteria.andEqualTo("createTime",sysUser.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysUser.getUpdateTime());
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
}
