package com.unisimon.monitorias.chapter.application.mapper;

import com.unisimon.monitorias.chapter.application.dto.InstructorResponse;
import com.unisimon.monitorias.chapter.domain.model.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InstructorResponseMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "schedule", source = "schedule")
    InstructorResponse toResponse(Instructor instructor);

    default List<InstructorResponse> toResponseList(List<Instructor> instructorList){
        return instructorList.stream().map(instructor -> {
            InstructorResponse instructorResponse = new InstructorResponse();
            instructorResponse.setName(instructor.getName());
            instructorResponse.setSchedule(instructor.getSchedule());
            return instructorResponse;
        }).collect(Collectors.toList());
    }
}
