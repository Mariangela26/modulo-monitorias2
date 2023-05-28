package com.unisimon.monitorias.chapter.domain.api;


import com.unisimon.monitorias.chapter.domain.model.Instructor;

import java.util.List;

public interface IInstructorServicePort {

    Instructor saveInstructor(Instructor instructor);

    List<Instructor> getAllInstructor();

    Instructor getInstructor(Long instructorId);

    void updateInstructor (Instructor instructor);

    void deleteInstructor(Long instructorId);

}
