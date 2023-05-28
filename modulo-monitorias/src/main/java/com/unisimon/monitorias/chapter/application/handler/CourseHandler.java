package com.unisimon.monitorias.chapter.application.handler;

import com.unisimon.monitorias.chapter.application.dto.CourseRequest;
import com.unisimon.monitorias.chapter.application.dto.CourseResponse;
import com.unisimon.monitorias.chapter.application.mapper.CourseRequestMapper;
import com.unisimon.monitorias.chapter.application.mapper.CourseResponseMapper;
import com.unisimon.monitorias.chapter.domain.api.ICourseServicePort;
import com.unisimon.monitorias.chapter.domain.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseHandler implements ICourseHandler{

    private final ICourseServicePort courseServicePort;
    private final CourseRequestMapper courseRequestMapper;
    private final CourseResponseMapper courseResponseMapper;

    @Override
    public CourseResponse saveCourse(CourseRequest courseRequest) {

        Course course = courseServicePort.saveCourse(courseRequestMapper.toCourse(courseRequest));

        return courseResponseMapper.toResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourse() {

        return courseResponseMapper.toResponseList(courseServicePort.getAllCourse());

    }

    @Override
    public CourseResponse getCourse(Long courseId) {

        Course course = courseServicePort.getCourse(courseId);
        return courseResponseMapper.toResponse(course);
    }

    @Override
    public void updateCourse(CourseRequest courseRequest, Long courseId) {
        Course oldCourse = courseServicePort.getCourse(courseId);
        Course newCourse = courseRequestMapper.toCourse(courseRequest);
        newCourse.setId(oldCourse.getId());
        courseServicePort.updateCourse(newCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseServicePort.getCourse(courseId);
        courseServicePort.deleteCourse(courseId);
    }
}
