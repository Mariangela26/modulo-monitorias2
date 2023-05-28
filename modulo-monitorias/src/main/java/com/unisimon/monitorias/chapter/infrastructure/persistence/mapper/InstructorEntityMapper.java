package com.unisimon.monitorias.chapter.infrastructure.persistence.mapper;

import com.unisimon.monitorias.chapter.domain.model.Instructor;
import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.InstructorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InstructorEntityMapper {

    InstructorEntity toEntity(Instructor instructor);
    Instructor toInstructor(InstructorEntity instructorEntity);
    List<Instructor> toInstructorList(List<InstructorEntity> instructorEntityList);

}
