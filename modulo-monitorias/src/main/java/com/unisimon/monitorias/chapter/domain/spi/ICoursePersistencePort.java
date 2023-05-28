package com.unisimon.monitorias.chapter.domain.spi;


import com.unisimon.monitorias.chapter.domain.model.Course;

import java.util.List;

public interface ICoursePersistencePort {

    Course saveCourse(Course course);

    List<Course> getAllCourse();

    Course getCourse(Long courseId);

    void updateCourse(Course course);

    void deleteCourse(Long courseId);

}
