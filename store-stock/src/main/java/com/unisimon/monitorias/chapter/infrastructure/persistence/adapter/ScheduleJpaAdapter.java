package com.unisimon.monitorias.chapter.infrastructure.persistence.adapter;

import com.unisimon.monitorias.chapter.domain.model.Schedule;
import com.unisimon.monitorias.chapter.domain.spi.ISchedulePersistencePort;
import com.unisimon.monitorias.chapter.infrastructure.exception.NoDataFoundException;
import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.ScheduleEntity;
import com.unisimon.monitorias.chapter.infrastructure.persistence.mapper.ScheduleEntityMapper;
import com.unisimon.monitorias.chapter.infrastructure.persistence.repository.IScheduleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class ScheduleJpaAdapter implements ISchedulePersistencePort {

    private final IScheduleRepository scheduleRepository;
    private final ScheduleEntityMapper scheduleEntityMapper;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        ScheduleEntity scheduleEntity = scheduleRepository.save(scheduleEntityMapper.toEntity(schedule));
        return scheduleEntityMapper.toSchedule(scheduleEntity);
    }

    @Override
    public List<Schedule> getAllSchedule() {
        List<ScheduleEntity> scheduleEntityList = scheduleRepository.findAll();
        if(scheduleEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return scheduleEntityMapper.toScheduleList(scheduleEntityList);

    }

    @Override
    public void updateSchedule(Schedule schedule) {

        scheduleRepository.save(scheduleEntityMapper.toEntity(schedule));

    }

    @Override
    public void deleteSchedule(Long scheduleId) {

        scheduleRepository.deleteById(scheduleId);
    }
}
