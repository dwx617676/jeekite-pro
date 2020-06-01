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
            // 主键ID
            if(!StringUtils.isEmpty(sysUser.getId())){
                    criteria.andEqualTo("id",sysUser.getId());
            }
            // 用户名
            if(!StringUtils.isEmpty(sysUser.getUsername())){
                    criteria.andLike("username","%"+sysUser.getUsername()+"%");
            }
            // 用户密码
            if(!StringUtils.isEmpty(sysUser.getPassword())){
                    criteria.andEqualTo("password",sysUser.getPassword());
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
