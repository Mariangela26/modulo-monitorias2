package com.pragma.store.chapter.infrastructure.persistence.repository;

import com.pragma.store.chapter.infrastructure.persistence.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeatRepository extends JpaRepository<SeatEntity, Long> {

}
