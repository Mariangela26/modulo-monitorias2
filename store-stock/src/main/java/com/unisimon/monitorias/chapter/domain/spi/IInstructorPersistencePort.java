package com.unisimon.monitorias.chapter.domain.spi;


import com.unisimon.monitorias.chapter.domain.model.Instructor;

import java.util.List;

public interface IInstructorPersistencePort {
    Instructor saveInstructor(Instructor instructor);

    List<Instructor> getAllInstructor();

    Instructor getInstructor(Long instructorId);

    void updateInstructor (Instructor instructor);

    void deleteInstructor(Long instructorId);

}
