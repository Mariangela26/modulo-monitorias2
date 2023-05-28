package com.unisimon.monitorias.chapter.infrastructure.persistence.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="instructor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    //Schedule schedule;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity scheduleEntity;

    @OneToMany(mappedBy = "instructorEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "courseId")
    private List<CourseEntity> courseEntityList;
}
