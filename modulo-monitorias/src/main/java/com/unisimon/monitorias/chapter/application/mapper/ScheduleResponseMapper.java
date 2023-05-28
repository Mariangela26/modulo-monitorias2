package com.unisimon.monitorias.chapter.application.mapper;

import com.unisimon.monitorias.chapter.application.dto.ScheduleResponse;
import com.unisimon.monitorias.chapter.domain.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", //tratamos el mapper como un bean
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleResponseMapper {

    @Mapping(target = "day", source = "day")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "place", source = "place")
    ScheduleResponse toResponse(Schedule schedule);

    default List<ScheduleResponse> toResponseList(List<Schedule> scheduleList){
        return scheduleList.stream().map(schedule -> {
            ScheduleResponse scheduleResponse = new ScheduleResponse();
            scheduleResponse.setDay(schedule.getDay());
            scheduleResponse.setStartTime(schedule.getStartTime());
            scheduleResponse.setEndTime(schedule.getEndTime());
            scheduleResponse.setPlace(schedule.getPlace());
            return scheduleResponse;
        }).collect(Collectors.toList());
    }

}
