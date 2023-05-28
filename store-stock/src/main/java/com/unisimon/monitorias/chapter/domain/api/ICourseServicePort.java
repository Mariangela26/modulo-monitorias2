package com.unisimon.monitorias.chapter.domain.api;


import com.unisimon.monitorias.chapter.domain.model.Course;

import java.util.List;

public interface ICourseServicePort {

    Course saveCourse(Course course);

    List<Course> getAllCourse();

    Course getCourse(Long courseId);

    void updateCourse(Course course);

    void deleteCourse(Long courseId);

}
