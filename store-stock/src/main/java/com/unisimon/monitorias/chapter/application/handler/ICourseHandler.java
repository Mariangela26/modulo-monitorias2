package com.unisimon.monitorias.chapter.application.handler;


import com.unisimon.monitorias.chapter.application.dto.CourseRequest;
import com.unisimon.monitorias.chapter.application.dto.CourseResponse;

import java.util.List;

public interface ICourseHandler {

    CourseResponse saveCourse(CourseRequest courseRequest);
    List<CourseResponse> getAllCourse();
    CourseResponse getCourse(Long courseId);
    void updateCourse(CourseRequest courseRequest, Long courseId);
    void deleteCourse(Long courseId);
}
