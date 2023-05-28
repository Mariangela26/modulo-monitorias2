package com.unisimon.monitorias.chapter.application.handler;

import com.unisimon.monitorias.chapter.application.dto.ScheduleRequest;
import com.unisimon.monitorias.chapter.application.dto.ScheduleResponse;
import com.unisimon.monitorias.chapter.application.mapper.ScheduleRequestMapper;
import com.unisimon.monitorias.chapter.application.mapper.ScheduleResponseMapper;
import com.unisimon.monitorias.chapter.domain.api.IScheduleServicePort;
import com.unisimon.monitorias.chapter.domain.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleHandler implements IScheduleHandler{

    private final IScheduleServicePort scheduleServicePort;
    private final ScheduleRequestMapper scheduleRequestMapper;
    private final ScheduleResponseMapper scheduleResponseMapper;
    @Override
    public ScheduleResponse saveSchedule(ScheduleRequest scheduleRequest) {
        Schedule schedule = scheduleServicePort.saveSchedule(scheduleRequestMapper.toSchedule(scheduleRequest));
        return scheduleResponseMapper.toResponse(schedule);
    }

    @Override
    public List<ScheduleResponse> getAllSchedule() {
        return scheduleResponseMapper.toResponseList(scheduleServicePort.getAllSchedule());
    }

    @Override
    public void updateSchedule(ScheduleRequest scheduleRequest, Long scheduleId) {

        //Schedule oldSchedule = s
        //TODO: falta obtener por id
    }

    @Override
    public void deleteSchedule(Long scheduleId) {

    }
}
