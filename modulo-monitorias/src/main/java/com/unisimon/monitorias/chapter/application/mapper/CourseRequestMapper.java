package com.unisimon.monitorias.chapter.application.mapper;

import com.unisimon.monitorias.chapter.application.dto.CourseRequest;
import com.unisimon.monitorias.chapter.domain.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseRequestMapper {
    Course toCourse(CourseRequest courseRequest);
}
