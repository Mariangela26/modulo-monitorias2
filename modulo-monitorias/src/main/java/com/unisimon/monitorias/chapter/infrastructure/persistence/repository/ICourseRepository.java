package com.unisimon.monitorias.chapter.infrastructure.persistence.repository;

import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<CourseEntity, Long> {
}
