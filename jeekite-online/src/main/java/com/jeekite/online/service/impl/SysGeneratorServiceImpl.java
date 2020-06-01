package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysGeneratorMapper;
import com.jeekite.online.pojo.SysGenerator;
import com.jeekite.online.service.SysGeneratorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysGenerator业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {

    @Autowired
    private SysGeneratorMapper sysGeneratorMapper;


    /**
     * SysGenerator条件+分页查询
     * @param sysGenerator 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysGenerator> findPage(SysGenerator sysGenerator, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysGenerator);
        //执行搜索
        return new PageInfo<SysGenerator>(sysGeneratorMapper.selectByExample(example));
    }

    /**
     * SysGenerator分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysGenerator> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysGenerator>(sysGeneratorMapper.selectAll());
    }

    /**
     * SysGenerator条件查询
     * @param sysGenerator
     * @return
     */
    @Override
    public List<SysGenerator> findList(SysGenerator sysGenerator){
        //构建查询条件
        Example example = createExample(sysGenerator);
        //根据构建的条件查询数据
        return sysGeneratorMapper.selectByExample(example);
    }


    /**
     * SysGenerator构建查询对象
     * @param sysGenerator
     * @return
     */
    public Example createExample(SysGenerator sysGenerator){
        Example example=new Example(SysGenerator.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysGenerator!=null){
            // ID
            if(!StringUtils.isEmpty(sysGenerator.getId())){
                    criteria.andEqualTo("id",sysGenerator.getId());
            }
            // 表名
            if(!StringUtils.isEmpty(sysGenerator.getTableName())){
                    criteria.andEqualTo("tableName",sysGenerator.getTableName());
            }
            // 菜单名称
            if(!StringUtils.isEmpty(sysGenerator.getMenuName())){
                    criteria.andEqualTo("menuName",sysGenerator.getMenuName());
            }
            // 上级菜单
            if(!StringUtils.isEmpty(sysGenerator.getPid())){
                    criteria.andEqualTo("pid",sysGenerator.getPid());
            }
            // 上次生成时间
            if(!StringUtils.isEmpty(sysGenerator.getGenTime())){
                    criteria.andEqualTo("genTime",sysGenerator.getGenTime());
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
        sysGeneratorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysGenerator
     * @param sysGenerator
     */
    @Override
    public void update(SysGenerator sysGenerator){
        sysGeneratorMapper.updateByPrimaryKey(sysGenerator);
    }

    /**
     * 增加SysGenerator
     * @param sysGenerator
     */
    @Override
    public void add(SysGenerator sysGenerator){
        sysGeneratorMapper.insert(sysGenerator);
    }

    /**
     * 根据ID查询SysGenerator
     * @param id
     * @return
     */
    @Override
    public SysGenerator findById(String id){
        return  sysGeneratorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysGenerator全部数据
     * @return
     */
    @Override
    public List<SysGenerator> findAll() {
        return sysGeneratorMapper.selectAll();
    }
}
