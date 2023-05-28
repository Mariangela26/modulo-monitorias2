package com.unisimon.monitorias.chapter.domain.api;


import com.unisimon.monitorias.chapter.domain.model.Schedule;

import java.util.List;

public interface IScheduleServicePort {

    Schedule saveSchedule(Schedule schedule);

    List<Schedule> getAllSchedule();

    void updateSchedule (Schedule schedule);

    void deleteSchedule(Long scheduleId);

}
