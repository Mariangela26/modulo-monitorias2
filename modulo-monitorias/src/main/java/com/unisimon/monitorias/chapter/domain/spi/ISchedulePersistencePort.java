package com.unisimon.monitorias.chapter.domain.spi;


import com.unisimon.monitorias.chapter.domain.model.Schedule;

import java.util.List;

public interface ISchedulePersistencePort {

    Schedule saveSchedule(Schedule schedule);

    List<Schedule> getAllSchedule();

    void updateSchedule (Schedule schedule);

    void deleteSchedule(Long scheduleId);

}
