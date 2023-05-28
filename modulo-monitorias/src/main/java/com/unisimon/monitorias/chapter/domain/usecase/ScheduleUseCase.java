package com.unisimon.monitorias.chapter.domain.usecase;

import com.unisimon.monitorias.chapter.domain.api.IScheduleServicePort;
import com.unisimon.monitorias.chapter.domain.model.Schedule;
import com.unisimon.monitorias.chapter.domain.spi.ISchedulePersistencePort;

import java.util.List;

public class ScheduleUseCase implements IScheduleServicePort {

    private final ISchedulePersistencePort schedulePersistencePort;

    public ScheduleUseCase(ISchedulePersistencePort schedulePersistencePort) {
        this.schedulePersistencePort = schedulePersistencePort;
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {

        return schedulePersistencePort.saveSchedule(schedule);
    }

    @Override
    public List<Schedule> getAllSchedule() {

        return schedulePersistencePort.getAllSchedule();
    }

    @Override
    public void updateSchedule(Schedule schedule) {

        schedulePersistencePort.updateSchedule(schedule);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {

        schedulePersistencePort.deleteSchedule(scheduleId);
    }
}
