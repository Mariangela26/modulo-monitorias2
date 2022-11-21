package com.pragma.store.chapter.infrastructure.persistence.repository;

import com.pragma.store.chapter.infrastructure.persistence.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
