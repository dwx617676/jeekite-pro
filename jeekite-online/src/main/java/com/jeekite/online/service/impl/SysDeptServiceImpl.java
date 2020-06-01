package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysDeptMapper;
import com.jeekite.online.pojo.SysDept;
import com.jeekite.online.service.SysDeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysDept业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;


    /**
     * SysDept条件+分页查询
     * @param sysDept 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysDept> findPage(SysDept sysDept, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysDept);
        //执行搜索
        return new PageInfo<SysDept>(sysDeptMapper.selectByExample(example));
    }

    /**
     * SysDept分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysDept> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysDept>(sysDeptMapper.selectAll());
    }

    /**
     * SysDept条件查询
     * @param sysDept
     * @return
     */
    @Override
    public List<SysDept> findList(SysDept sysDept){
        //构建查询条件
        Example example = createExample(sysDept);
        //根据构建的条件查询数据
        return sysDeptMapper.selectByExample(example);
    }


    /**
     * SysDept构建查询对象
     * @param sysDept
     * @return
     */
    public Example createExample(SysDept sysDept){
        Example example=new Example(SysDept.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysDept!=null){
            // 主键
            if(!StringUtils.isEmpty(sysDept.getId())){
                    criteria.andEqualTo("id",sysDept.getId());
            }
            // 部门编号(规则：父级关系编码+自己的编码)
            if(!StringUtils.isEmpty(sysDept.getDeptNo())){
                    criteria.andEqualTo("deptNo",sysDept.getDeptNo());
            }
            // 部门名称
            if(!StringUtils.isEmpty(sysDept.getName())){
                    criteria.andLike("name","%"+sysDept.getName()+"%");
            }
            // 父级id
            if(!StringUtils.isEmpty(sysDept.getPid())){
                    criteria.andEqualTo("pid",sysDept.getPid());
            }
            // 状态(1:正常；0:弃用)
            if(!StringUtils.isEmpty(sysDept.getStatus())){
                    criteria.andEqualTo("status",sysDept.getStatus());
            }
            // 为了维护更深层级关系
            if(!StringUtils.isEmpty(sysDept.getRelationCode())){
                    criteria.andEqualTo("relationCode",sysDept.getRelationCode());
            }
            // 部门经理user_id
            if(!StringUtils.isEmpty(sysDept.getDeptManagerId())){
                    criteria.andEqualTo("deptManagerId",sysDept.getDeptManagerId());
            }
            // 部门经理名称
            if(!StringUtils.isEmpty(sysDept.getManagerName())){
                    criteria.andEqualTo("managerName",sysDept.getManagerName());
            }
            // 部门经理联系电话
            if(!StringUtils.isEmpty(sysDept.getPhone())){
                    criteria.andEqualTo("phone",sysDept.getPhone());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysDept.getCreateTime())){
                    criteria.andEqualTo("createTime",sysDept.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sysDept.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sysDept.getUpdateTime());
            }
            // 是否删除(1未删除；0已删除)
            if(!StringUtils.isEmpty(sysDept.getDeleted())){
                    criteria.andEqualTo("deleted",sysDept.getDeleted());
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
        sysDeptMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysDept
     * @param sysDept
     */
    @Override
    public void update(SysDept sysDept){
        sysDeptMapper.updateByPrimaryKey(sysDept);
    }

    /**
     * 增加SysDept
     * @param sysDept
     */
    @Override
    public void add(SysDept sysDept){
        sysDeptMapper.insert(sysDept);
    }

    /**
     * 根据ID查询SysDept
     * @param id
     * @return
     */
    @Override
    public SysDept findById(String id){
        return  sysDeptMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysDept全部数据
     * @return
     */
    @Override
    public List<SysDept> findAll() {
        return sysDeptMapper.selectAll();
    }
}
