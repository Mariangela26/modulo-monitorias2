package com.unisimon.monitorias.chapter.infrastructure.persistence.mapper;

import com.unisimon.monitorias.chapter.domain.model.Schedule;
import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ScheduleEntityMapper {

    ScheduleEntity toEntity(Schedule schedule);
    Schedule toSchedule(ScheduleEntity scheduleEntity);
    List<Schedule> toScheduleList(List<ScheduleEntity> scheduleEntityList);
}
