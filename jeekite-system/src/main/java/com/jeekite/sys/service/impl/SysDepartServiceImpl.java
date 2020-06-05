package com.jeekite.sys.service.impl;

import com.jeekite.sys.entity.DepartIdModel;
import com.jeekite.sys.entity.SysDepart;
import com.jeekite.sys.entity.SysDepartTreeModel;
import com.jeekite.sys.service.ISysDepartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDepartServiceImpl implements ISysDepartService {
    @Override
    public List<SysDepartTreeModel> queryMyDeptTreeList(String departIds) {
        return null;
    }

    @Override
    public List<SysDepartTreeModel> queryTreeList() {
        return null;
    }

    @Override
    public List<DepartIdModel> queryDepartIdTreeList() {
        return null;
    }

    @Override
    public void saveDepartData(SysDepart sysDepart, String username) {

    }

    @Override
    public Boolean updateDepartDataById(SysDepart sysDepart, String username) {
        return null;
    }

    @Override
    public List<SysDepartTreeModel> searhBy(String keyWord, String myDeptSearch, String departIds) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<SysDepart> queryUserDeparts(String userId) {
        return null;
    }

    @Override
    public List<SysDepart> queryDepartsByUsername(String username) {
        return null;
    }

    @Override
    public void deleteBatchWithChildren(List<String> ids) {

    }

    @Override
    public List<String> getSubDepIdsByDepId(String departId) {
        return null;
    }

    @Override
    public List<String> getMySubDepIdsByDepId(String departIds) {
        return null;
    }
}
