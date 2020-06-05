package com.jeekite.sys.service.impl;
import com.jeekite.sys.mapper.SysPermissionMapper;
import com.jeekite.sys.entity.SysPermission;
import com.jeekite.sys.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysPermission业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    /**
     * SysPermission条件+分页查询
     * @param sysPermission 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysPermission> findPage(SysPermission sysPermission, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysPermission);
        //执行搜索
        return new PageInfo<SysPermission>(sysPermissionMapper.selectByExample(example));
    }

    /**
     * SysPermission分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysPermission> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysPermission>(sysPermissionMapper.selectAll());
    }

    /**
     * SysPermission条件查询
     * @param sysPermission
     * @return
     */
    @Override
    public List<SysPermission> findList(SysPermission sysPermission){
        //构建查询条件
        Example example = createExample(sysPermission);
        //根据构建的条件查询数据
        return sysPermissionMapper.selectByExample(example);
    }


    /**
     * SysPermission构建查询对象
     * @param sysPermission
     * @return
     */
    public Example createExample(SysPermission sysPermission){
        Example example=new Example(SysPermission.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysPermission!=null){
            // 主键id
            if(!StringUtils.isEmpty(sysPermission.getId())){
                    criteria.andEqualTo("id",sysPermission.getId());
            }
            // 父id
            if(!StringUtils.isEmpty(sysPermission.getParentId())){
                    criteria.andEqualTo("parentId",sysPermission.getParentId());
            }
            // 菜单标题
            if(!StringUtils.isEmpty(sysPermission.getName())){
                    criteria.andLike("name","%"+sysPermission.getName()+"%");
            }
            // 路径
            if(!StringUtils.isEmpty(sysPermission.getUrl())){
                    criteria.andEqualTo("url",sysPermission.getUrl());
            }
            // 组件
            if(!StringUtils.isEmpty(sysPermission.getComponent())){
                    criteria.andEqualTo("component",sysPermission.getComponent());
            }
            // 组件名字
            if(!StringUtils.isEmpty(sysPermission.getComponentName())){
                    criteria.andEqualTo("componentName",sysPermission.getComponentName());
            }
            // 一级菜单跳转地址
            if(!StringUtils.isEmpty(sysPermission.getRedirect())){
                    criteria.andEqualTo("redirect",sysPermission.getRedirect());
            }
            // 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
            if(!StringUtils.isEmpty(sysPermission.getMenuType())){
                    criteria.andEqualTo("menuType",sysPermission.getMenuType());
            }
            // 菜单权限编码
            if(!StringUtils.isEmpty(sysPermission.getPerms())){
                    criteria.andEqualTo("perms",sysPermission.getPerms());
            }
            // 权限策略1显示2禁用
            if(!StringUtils.isEmpty(sysPermission.getPermsType())){
                    criteria.andEqualTo("permsType",sysPermission.getPermsType());
            }
            // 菜单排序
            if(!StringUtils.isEmpty(sysPermission.getSortNo())){
                    criteria.andEqualTo("sortNo",sysPermission.getSortNo());
            }
            // 聚合子路由: 1是0否
            if(!StringUtils.isEmpty(sysPermission.getAlwaysShow())){
                    criteria.andEqualTo("alwaysShow",sysPermission.getAlwaysShow());
            }
            // 菜单图标
            if(!StringUtils.isEmpty(sysPermission.getIcon())){
                    criteria.andEqualTo("icon",sysPermission.getIcon());
            }
            // 是否路由菜单: 0:不是  1:是（默认值1）
            if(!StringUtils.isEmpty(sysPermission.getIsRoute())){
                    criteria.andEqualTo("isRoute",sysPermission.getIsRoute());
            }
            // 是否叶子节点:    1:是   0:不是
            if(!StringUtils.isEmpty(sysPermission.getIsLeaf())){
                    criteria.andEqualTo("isLeaf",sysPermission.getIsLeaf());
            }
            // 是否缓存该页面:    1:是   0:不是
            if(!StringUtils.isEmpty(sysPermission.getKeepAlive())){
                    criteria.andEqualTo("keepAlive",sysPermission.getKeepAlive());
            }
            // 是否隐藏路由: 0否,1是
            if(!StringUtils.isEmpty(sysPermission.getHidden())){
                    criteria.andEqualTo("hidden",sysPermission.getHidden());
            }
            // 描述
            if(!StringUtils.isEmpty(sysPermission.getDescription())){
                    criteria.andEqualTo("description",sysPermission.getDescription());
            }
            // 创建人
            if(!StringUtils.isEmpty(sysPermission.getCreateBy())){
                    criteria.andEqualTo("createBy",sysPermission.getCreateBy());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysPermission.getCreateTime())){
                    criteria.andEqualTo("createTime",sysPermission.getCreateTime());
            }
            // 更新人
            if(!StringUtils.isEmpty(sysPermission.getUpdateBy())){
                    criteria.andEqualTo("updateBy",sysPermission.getUpdateBy());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sysPermission.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysPermission.getUpdateTime());
            }
            // 删除状态 0正常 1已删除
            if(!StringUtils.isEmpty(sysPermission.getDelFlag())){
                    criteria.andEqualTo("delFlag",sysPermission.getDelFlag());
            }
            // 是否添加数据权限1是0否
            if(!StringUtils.isEmpty(sysPermission.getRuleFlag())){
                    criteria.andEqualTo("ruleFlag",sysPermission.getRuleFlag());
            }
            // 按钮权限状态(0无效1有效)
            if(!StringUtils.isEmpty(sysPermission.getStatus())){
                    criteria.andEqualTo("status",sysPermission.getStatus());
            }
            // 外链菜单打开方式 0/内部打开 1/外部打开
            if(!StringUtils.isEmpty(sysPermission.getInternalOrExternal())){
                    criteria.andEqualTo("internalOrExternal",sysPermission.getInternalOrExternal());
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
        sysPermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysPermission
     * @param sysPermission
     */
    @Override
    public void update(SysPermission sysPermission){
        sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    /**
     * 增加SysPermission
     * @param sysPermission
     */
    @Override
    public void add(SysPermission sysPermission){
        sysPermissionMapper.insert(sysPermission);
    }

    /**
     * 根据ID查询SysPermission
     * @param id
     * @return
     */
    @Override
    public SysPermission findById(String id){
        return  sysPermissionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysPermission全部数据
     * @return
     */
    @Override
    public List<SysPermission> findAll() {
        return sysPermissionMapper.selectAll();
    }
}
