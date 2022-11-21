package com.pragma.store.chapter.infrastructure.persistence.repository;

import com.pragma.store.chapter.infrastructure.persistence.entity.ProductSupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductSupplyRepository extends JpaRepository<ProductSupplyEntity, Long> {
}
