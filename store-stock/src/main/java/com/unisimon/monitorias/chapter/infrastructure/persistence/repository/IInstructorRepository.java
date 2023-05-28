package com.unisimon.monitorias.chapter.infrastructure.persistence.repository;

import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstructorRepository extends JpaRepository<InstructorEntity, Long> {
}
