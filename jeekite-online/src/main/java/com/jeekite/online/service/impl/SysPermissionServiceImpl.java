package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysPermissionMapper;
import com.jeekite.online.pojo.SysPermission;
import com.jeekite.online.service.SysPermissionService;
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
            // 主键
            if(!StringUtils.isEmpty(sysPermission.getId())){
                    criteria.andEqualTo("id",sysPermission.getId());
            }
            // 菜单权限名称
            if(!StringUtils.isEmpty(sysPermission.getName())){
                    criteria.andLike("name","%"+sysPermission.getName()+"%");
            }
            // 授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)
            if(!StringUtils.isEmpty(sysPermission.getPerms())){
                    criteria.andEqualTo("perms",sysPermission.getPerms());
            }
            // 图标
            if(!StringUtils.isEmpty(sysPermission.getIcon())){
                    criteria.andEqualTo("icon",sysPermission.getIcon());
            }
            // 访问地址URL
            if(!StringUtils.isEmpty(sysPermission.getUrl())){
                    criteria.andEqualTo("url",sysPermission.getUrl());
            }
            // a target属性:_self _blank
            if(!StringUtils.isEmpty(sysPermission.getTarget())){
                    criteria.andEqualTo("target",sysPermission.getTarget());
            }
            // 父级菜单权限名称
            if(!StringUtils.isEmpty(sysPermission.getPid())){
                    criteria.andEqualTo("pid",sysPermission.getPid());
            }
            // 排序
            if(!StringUtils.isEmpty(sysPermission.getOrderNum())){
                    criteria.andEqualTo("orderNum",sysPermission.getOrderNum());
            }
            // 菜单权限类型(1:目录;2:菜单;3:按钮)
            if(!StringUtils.isEmpty(sysPermission.getType())){
                    criteria.andEqualTo("type",sysPermission.getType());
            }
            // 状态1:正常 0：禁用
            if(!StringUtils.isEmpty(sysPermission.getStatus())){
                    criteria.andEqualTo("status",sysPermission.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysPermission.getCreateTime())){
                    criteria.andEqualTo("createTime",sysPermission.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sysPermission.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysPermission.getUpdateTime());
            }
            // 是否删除(1未删除；0已删除)
            if(!StringUtils.isEmpty(sysPermission.getDeleted())){
                    criteria.andEqualTo("deleted",sysPermission.getDeleted());
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
