package com.unisimon.monitorias.chapter.application.handler;

import com.unisimon.monitorias.chapter.application.dto.InstructorRequest;
import com.unisimon.monitorias.chapter.application.dto.InstructorResponse;
import com.unisimon.monitorias.chapter.application.mapper.InstructorRequestMapper;
import com.unisimon.monitorias.chapter.application.mapper.InstructorResponseMapper;
import com.unisimon.monitorias.chapter.domain.api.IInstructorServicePort;
import com.unisimon.monitorias.chapter.domain.model.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorHandler implements IInstructorHandler{

    private final IInstructorServicePort instructorServicePort;
    private final InstructorRequestMapper instructorRequestMapper;
    private final InstructorResponseMapper instructorResponseMapper;

    @Override
    public InstructorResponse saveInstructor(InstructorRequest instructorRequest) {

        Instructor instructor = instructorServicePort.saveInstructor(instructorRequestMapper.toInstructor(instructorRequest));
        return instructorResponseMapper.toResponse(instructor);
    }

    @Override
    public List<InstructorResponse> getAllInstructor() {

        return instructorResponseMapper.toResponseList(instructorServicePort.getAllInstructor());

    }

    @Override
    public InstructorResponse getInstructor(Long instructorId) {

        Instructor instructor = instructorServicePort.getInstructor(instructorId);
        return instructorResponseMapper.toResponse(instructor);
    }

    @Override
    public void updateInstructor(InstructorRequest instructorRequest, Long instructorId) {

        Instructor oldInstructor = instructorServicePort.getInstructor(instructorId);
        Instructor newInstructor = instructorRequestMapper.toInstructor(instructorRequest);
        newInstructor.setId(oldInstructor.getId());
        instructorServicePort.updateInstructor(newInstructor);
    }

    @Override
    public void deleteInstructor(Long instructorId) {

        Instructor instructor = instructorServicePort.getInstructor(instructorId);
        instructorServicePort.deleteInstructor(instructorId);
    }
}
