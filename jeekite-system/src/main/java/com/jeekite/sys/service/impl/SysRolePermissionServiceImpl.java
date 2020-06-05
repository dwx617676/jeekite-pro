package com.jeekite.sys.service.impl;
import com.jeekite.sys.mapper.SysRolePermissionMapper;
import com.jeekite.sys.entity.SysRolePermission;
import com.jeekite.sys.service.SysRolePermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysRolePermission业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;


    /**
     * SysRolePermission条件+分页查询
     * @param sysRolePermission 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysRolePermission> findPage(SysRolePermission sysRolePermission, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysRolePermission);
        //执行搜索
        return new PageInfo<SysRolePermission>(sysRolePermissionMapper.selectByExample(example));
    }

    /**
     * SysRolePermission分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysRolePermission> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysRolePermission>(sysRolePermissionMapper.selectAll());
    }

    /**
     * SysRolePermission条件查询
     * @param sysRolePermission
     * @return
     */
    @Override
    public List<SysRolePermission> findList(SysRolePermission sysRolePermission){
        //构建查询条件
        Example example = createExample(sysRolePermission);
        //根据构建的条件查询数据
        return sysRolePermissionMapper.selectByExample(example);
    }


    /**
     * SysRolePermission构建查询对象
     * @param sysRolePermission
     * @return
     */
    public Example createExample(SysRolePermission sysRolePermission){
        Example example=new Example(SysRolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysRolePermission!=null){
            // 
            if(!StringUtils.isEmpty(sysRolePermission.getId())){
                    criteria.andEqualTo("id",sysRolePermission.getId());
            }
            // 角色id
            if(!StringUtils.isEmpty(sysRolePermission.getRoleId())){
                    criteria.andEqualTo("roleId",sysRolePermission.getRoleId());
            }
            // 权限id
            if(!StringUtils.isEmpty(sysRolePermission.getPermissionId())){
                    criteria.andEqualTo("permissionId",sysRolePermission.getPermissionId());
            }
            // 
            if(!StringUtils.isEmpty(sysRolePermission.getDataRuleIds())){
                    criteria.andEqualTo("dataRuleIds",sysRolePermission.getDataRuleIds());
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
        sysRolePermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysRolePermission
     * @param sysRolePermission
     */
    @Override
    public void update(SysRolePermission sysRolePermission){
        sysRolePermissionMapper.updateByPrimaryKey(sysRolePermission);
    }

    /**
     * 增加SysRolePermission
     * @param sysRolePermission
     */
    @Override
    public void add(SysRolePermission sysRolePermission){
        sysRolePermissionMapper.insert(sysRolePermission);
    }

    /**
     * 根据ID查询SysRolePermission
     * @param id
     * @return
     */
    @Override
    public SysRolePermission findById(String id){
        return  sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysRolePermission全部数据
     * @return
     */
    @Override
    public List<SysRolePermission> findAll() {
        return sysRolePermissionMapper.selectAll();
    }
}
