package com.pragma.store.chapter.infrastructure.persistence.dao;

import com.pragma.store.chapter.infrastructure.persistence.entity.AssessmentScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentScheduleDao extends CrudRepository<AssessmentScheduleEntity, Long>, AssessmentScheduleCustomDao {

    List<AssessmentScheduleEntity> findByUserEmail(String userEmail);
}
