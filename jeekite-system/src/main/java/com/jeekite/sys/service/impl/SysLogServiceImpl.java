package com.jeekite.sys.service.impl;

import com.jeekite.sys.entity.SysLog;
import com.jeekite.sys.mapper.SysLogMapper;
import com.jeekite.sys.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public Long findTotalVisitCount() {
        return sysLogMapper.findTodayVisitCount();
    }

    @Override
    public Long findTodayVisitCount(Date dayStart, Date dayEnd) {
        return sysLogMapper.findTodayVisitCount(dayStart,dayEnd);
    }

    @Override
    public Long findTodayIp(Date dayStart, Date dayEnd) {
        return sysLogMapper.findTodayIp(dayStart,dayEnd);
    }

    @Override
    public List<Map<String, Object>> findVisitCount(Date dayStart, Date dayEnd) {
        return sysLogMapper.findVisitCount(dayStart,dayEnd);
    }
}
