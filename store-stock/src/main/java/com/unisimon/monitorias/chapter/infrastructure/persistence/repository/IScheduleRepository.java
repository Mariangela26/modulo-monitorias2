package com.unisimon.monitorias.chapter.infrastructure.persistence.repository;

import com.unisimon.monitorias.chapter.infrastructure.persistence.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}
