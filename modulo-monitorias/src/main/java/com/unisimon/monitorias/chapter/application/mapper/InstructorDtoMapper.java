package com.unisimon.monitorias.chapter.application.mapper;

import com.unisimon.monitorias.chapter.application.dto.InstructorDto;
import com.unisimon.monitorias.chapter.domain.model.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InstructorDtoMapper {

    InstructorDto toDto(Instructor instructor);
}
