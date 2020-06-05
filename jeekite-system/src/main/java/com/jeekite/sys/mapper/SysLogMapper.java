package com.jeekite.sys.mapper;

import com.jeekite.sys.entity.SysLog;
import org.apache.ibatis.annotations.Select;
import  tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysLogMapper extends Mapper<SysLog> {

    Long findTodayVisitCount();
    Long findTodayVisitCount(Date dayStart, Date dayEnd);
    Long findTodayIp(Date dayStart, Date dayEnd);
    List<Map<String, Object>> findVisitCount(Date dayStart, Date dayEnd);
}
