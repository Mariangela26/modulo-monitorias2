package com.unisimon.monitorias.chapter.application.dto;

import com.unisimon.monitorias.chapter.domain.model.Instructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String name;
    private Instructor instructor;
}
