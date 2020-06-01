package com.jeekite.online.service.impl;
import com.jeekite.online.dao.SysDictDetailMapper;
import com.jeekite.online.pojo.SysDictDetail;
import com.jeekite.online.service.SysDictDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysDictDetail业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysDictDetailServiceImpl implements SysDictDetailService {

    @Autowired
    private SysDictDetailMapper sysDictDetailMapper;


    /**
     * SysDictDetail条件+分页查询
     * @param sysDictDetail 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysDictDetail> findPage(SysDictDetail sysDictDetail, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysDictDetail);
        //执行搜索
        return new PageInfo<SysDictDetail>(sysDictDetailMapper.selectByExample(example));
    }

    /**
     * SysDictDetail分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysDictDetail> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysDictDetail>(sysDictDetailMapper.selectAll());
    }

    /**
     * SysDictDetail条件查询
     * @param sysDictDetail
     * @return
     */
    @Override
    public List<SysDictDetail> findList(SysDictDetail sysDictDetail){
        //构建查询条件
        Example example = createExample(sysDictDetail);
        //根据构建的条件查询数据
        return sysDictDetailMapper.selectByExample(example);
    }


    /**
     * SysDictDetail构建查询对象
     * @param sysDictDetail
     * @return
     */
    public Example createExample(SysDictDetail sysDictDetail){
        Example example=new Example(SysDictDetail.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysDictDetail!=null){
            // 
            if(!StringUtils.isEmpty(sysDictDetail.getId())){
                    criteria.andEqualTo("id",sysDictDetail.getId());
            }
            // 字典标签
            if(!StringUtils.isEmpty(sysDictDetail.getLabel())){
                    criteria.andEqualTo("label",sysDictDetail.getLabel());
            }
            // 字典值
            if(!StringUtils.isEmpty(sysDictDetail.getValue())){
                    criteria.andEqualTo("value",sysDictDetail.getValue());
            }
            // 排序
            if(!StringUtils.isEmpty(sysDictDetail.getSort())){
                    criteria.andEqualTo("sort",sysDictDetail.getSort());
            }
            // 字典id
            if(!StringUtils.isEmpty(sysDictDetail.getDictId())){
                    criteria.andEqualTo("dictId",sysDictDetail.getDictId());
            }
            // 创建日期
            if(!StringUtils.isEmpty(sysDictDetail.getCreateTime())){
                    criteria.andEqualTo("createTime",sysDictDetail.getCreateTime());
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
        sysDictDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysDictDetail
     * @param sysDictDetail
     */
    @Override
    public void update(SysDictDetail sysDictDetail){
        sysDictDetailMapper.updateByPrimaryKey(sysDictDetail);
    }

    /**
     * 增加SysDictDetail
     * @param sysDictDetail
     */
    @Override
    public void add(SysDictDetail sysDictDetail){
        sysDictDetailMapper.insert(sysDictDetail);
    }

    /**
     * 根据ID查询SysDictDetail
     * @param id
     * @return
     */
    @Override
    public SysDictDetail findById(String id){
        return  sysDictDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysDictDetail全部数据
     * @return
     */
    @Override
    public List<SysDictDetail> findAll() {
        return sysDictDetailMapper.selectAll();
    }
}
