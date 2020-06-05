package com.jeekite.sys.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ISysLogService {
    Long findTotalVisitCount();

    Long findTodayVisitCount(Date dayStart, Date dayEnd);

    Long findTodayIp(Date dayStart, Date dayEnd);

    List<Map<String, Object>> findVisitCount(Date dayStart, Date dayEnd);
}
