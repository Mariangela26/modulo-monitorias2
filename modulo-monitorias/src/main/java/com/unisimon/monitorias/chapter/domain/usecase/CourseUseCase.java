package com.unisimon.monitorias.chapter.domain.usecase;

import com.unisimon.monitorias.chapter.domain.api.ICourseServicePort;
import com.unisimon.monitorias.chapter.domain.model.Course;
import com.unisimon.monitorias.chapter.domain.spi.ICoursePersistencePort;

import java.util.List;

public class CourseUseCase implements ICourseServicePort {

    private final ICoursePersistencePort coursePersistencePort;

    public CourseUseCase(ICoursePersistencePort coursePersistencePort) {
        this.coursePersistencePort = coursePersistencePort;
    }

    @Override
    public Course saveCourse(Course course) {

        return coursePersistencePort.saveCourse(course);
    }

    @Override
    public List<Course> getAllCourse() {

        return coursePersistencePort.getAllCourse();
    }

    @Override
    public Course getCourse(Long courseId) {

        return coursePersistencePort.getCourse(courseId);
    }

    @Override
    public void updateCourse(Course course) {

        coursePersistencePort.updateCourse(course);
    }

    @Override
    public void deleteCourse(Long courseId) {

        coursePersistencePort.deleteCourse(courseId);
    }
}
