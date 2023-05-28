package com.unisimon.monitorias.chapter.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    private Long id;
    private String name;
    private Instructor instructor;

}
