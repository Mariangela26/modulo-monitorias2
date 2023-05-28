package com.unisimon.monitorias.chapter.application.handler;


import com.unisimon.monitorias.chapter.application.dto.ScheduleRequest;
import com.unisimon.monitorias.chapter.application.dto.ScheduleResponse;

import java.util.List;

public interface IScheduleHandler {

    ScheduleResponse saveSchedule(ScheduleRequest scheduleRequest);
    List<ScheduleResponse> getAllSchedule();
    void updateSchedule(ScheduleRequest scheduleRequest, Long scheduleId);
    void deleteSchedule(Long scheduleId);
}
