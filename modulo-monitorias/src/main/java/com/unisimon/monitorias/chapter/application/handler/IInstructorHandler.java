package com.unisimon.monitorias.chapter.application.handler;


import com.unisimon.monitorias.chapter.application.dto.InstructorRequest;
import com.unisimon.monitorias.chapter.application.dto.InstructorResponse;

import java.util.List;

public interface IInstructorHandler {

    InstructorResponse saveInstructor(InstructorRequest instructorRequest);
    List<InstructorResponse> getAllInstructor();
    InstructorResponse getInstructor(Long instructorId);
    void updateInstructor(InstructorRequest instructorRequest, Long instructorId);
    void deleteInstructor(Long instructorId);
}
