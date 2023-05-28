package com.unisimon.monitorias.chapter.infrastructure.persistence.adapter;

import com.unisimon.monitorias.chapter.domain.model.Course;
import com.unisimon.monitorias.chapter.domain.spi.ICoursePersistencePort;
import com.unisimon.monitorias.chapter.infrastructure.exception.NoDataFoundException;
import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.CourseEntity;
import com.unisimon.monitorias.chapter.infrastructure.persistence.mapper.CourseEntityMapper;
import com.unisimon.monitorias.chapter.infrastructure.persistence.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseJpaAdapter implements ICoursePersistencePort {

    private final ICourseRepository courseRepository;
    private final CourseEntityMapper courseEntityMapper;
    @Override
    public Course saveCourse(Course course) {

        CourseEntity courseEntity = courseRepository.save(courseEntityMapper.toEntity(course));
        return courseEntityMapper.toCourse(courseEntity);
    }

    @Override
    public List<Course> getAllCourse() {
        List<CourseEntity> courseEntityList = courseRepository.findAll();
        if(courseEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return courseEntityMapper.toCourseList(courseEntityList);

    }

    @Override
    public Course getCourse(Long courseId) {
        if(!courseRepository.findById(courseId).isPresent()){

        }
        return courseEntityMapper.toCourse(courseRepository.findById(courseId).orElseThrow());

    }

    @Override
    public void updateCourse(Course course) {

        courseRepository.save(courseEntityMapper.toEntity(course));

    }

    @Override
    public void deleteCourse(Long courseId) {

        courseRepository.deleteById(courseId);
    }
}
