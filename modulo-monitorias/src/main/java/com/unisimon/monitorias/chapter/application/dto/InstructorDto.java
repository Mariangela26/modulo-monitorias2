package com.unisimon.monitorias.chapter.application.dto;

import com.unisimon.monitorias.chapter.domain.model.Course;
import com.unisimon.monitorias.chapter.domain.model.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InstructorDto {
    private Long id;
    private String name;
    private Schedule schedule;
    private List<Course> courseList;
}
