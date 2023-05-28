package com.unisimon.monitorias.chapter.application.mapper;

import com.unisimon.monitorias.chapter.application.dto.CourseResponse;
import com.unisimon.monitorias.chapter.domain.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseResponseMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "instructor", source = "instructor")
    CourseResponse toResponse(Course course);

    default List<CourseResponse> toResponseList(List<Course> courseList){
        return courseList.stream().map(course -> {
            CourseResponse courseResponse = new CourseResponse();
            courseResponse.setName(course.getName());
            courseResponse.setInstructor(course.getInstructor());
            return courseResponse;
        }).collect(Collectors.toList());
    }
}
