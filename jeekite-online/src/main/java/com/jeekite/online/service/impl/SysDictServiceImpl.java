package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysDictMapper;
import com.jeekite.online.pojo.SysDict;
import com.jeekite.online.service.SysDictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysDict业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;


    /**
     * SysDict条件+分页查询
     * @param sysDict 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysDict> findPage(SysDict sysDict, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysDict);
        //执行搜索
        return new PageInfo<SysDict>(sysDictMapper.selectByExample(example));
    }

    /**
     * SysDict分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysDict> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysDict>(sysDictMapper.selectAll());
    }

    /**
     * SysDict条件查询
     * @param sysDict
     * @return
     */
    @Override
    public List<SysDict> findList(SysDict sysDict){
        //构建查询条件
        Example example = createExample(sysDict);
        //根据构建的条件查询数据
        return sysDictMapper.selectByExample(example);
    }


    /**
     * SysDict构建查询对象
     * @param sysDict
     * @return
     */
    public Example createExample(SysDict sysDict){
        Example example=new Example(SysDict.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysDict!=null){
            // 
            if(!StringUtils.isEmpty(sysDict.getId())){
                    criteria.andEqualTo("id",sysDict.getId());
            }
            // 字典名称
            if(!StringUtils.isEmpty(sysDict.getName())){
                    criteria.andLike("name","%"+sysDict.getName()+"%");
            }
            // 描述
            if(!StringUtils.isEmpty(sysDict.getRemark())){
                    criteria.andEqualTo("remark",sysDict.getRemark());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sysDict.getCreateTime())){
                    criteria.andEqualTo("createTime",sysDict.getCreateTime());
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
        sysDictMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysDict
     * @param sysDict
     */
    @Override
    public void update(SysDict sysDict){
        sysDictMapper.updateByPrimaryKey(sysDict);
    }

    /**
     * 增加SysDict
     * @param sysDict
     */
    @Override
    public void add(SysDict sysDict){
        sysDictMapper.insert(sysDict);
    }

    /**
     * 根据ID查询SysDict
     * @param id
     * @return
     */
    @Override
    public SysDict findById(String id){
        return  sysDictMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysDict全部数据
     * @return
     */
    @Override
    public List<SysDict> findAll() {
        return sysDictMapper.selectAll();
    }
}
