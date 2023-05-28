package com.unisimon.monitorias.chapter.application.mapper;

import com.unisimon.monitorias.chapter.application.dto.ScheduleRequest;
import com.unisimon.monitorias.chapter.domain.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleRequestMapper {

    Schedule toSchedule(ScheduleRequest scheduleRequest);

}
