package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysUserRoleMapper;
import com.jeekite.online.pojo.SysUserRole;
import com.jeekite.online.service.SysUserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysUserRole业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    /**
     * SysUserRole条件+分页查询
     * @param sysUserRole 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysUserRole> findPage(SysUserRole sysUserRole, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysUserRole);
        //执行搜索
        return new PageInfo<SysUserRole>(sysUserRoleMapper.selectByExample(example));
    }

    /**
     * SysUserRole分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysUserRole> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysUserRole>(sysUserRoleMapper.selectAll());
    }

    /**
     * SysUserRole条件查询
     * @param sysUserRole
     * @return
     */
    @Override
    public List<SysUserRole> findList(SysUserRole sysUserRole){
        //构建查询条件
        Example example = createExample(sysUserRole);
        //根据构建的条件查询数据
        return sysUserRoleMapper.selectByExample(example);
    }


    /**
     * SysUserRole构建查询对象
     * @param sysUserRole
     * @return
     */
    public Example createExample(SysUserRole sysUserRole){
        Example example=new Example(SysUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysUserRole!=null){
            // 用户id
            if(!StringUtils.isEmpty(sysUserRole.getId())){
                    criteria.andEqualTo("id",sysUserRole.getId());
            }
            // 
            if(!StringUtils.isEmpty(sysUserRole.getUserId())){
                    criteria.andEqualTo("userId",sysUserRole.getUserId());
            }
            // 角色id
            if(!StringUtils.isEmpty(sysUserRole.getRoleId())){
                    criteria.andEqualTo("roleId",sysUserRole.getRoleId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysUserRole.getCreateTime())){
                    criteria.andEqualTo("createTime",sysUserRole.getCreateTime());
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
        sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysUserRole
     * @param sysUserRole
     */
    @Override
    public void update(SysUserRole sysUserRole){
        sysUserRoleMapper.updateByPrimaryKey(sysUserRole);
    }

    /**
     * 增加SysUserRole
     * @param sysUserRole
     */
    @Override
    public void add(SysUserRole sysUserRole){
        sysUserRoleMapper.insert(sysUserRole);
    }

    /**
     * 根据ID查询SysUserRole
     * @param id
     * @return
     */
    @Override
    public SysUserRole findById(String id){
        return  sysUserRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysUserRole全部数据
     * @return
     */
    @Override
    public List<SysUserRole> findAll() {
        return sysUserRoleMapper.selectAll();
    }
}
