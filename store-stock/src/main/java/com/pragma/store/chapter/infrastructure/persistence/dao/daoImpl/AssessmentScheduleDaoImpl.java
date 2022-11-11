package com.pragma.store.chapter.infrastructure.persistence.dao.daoImpl;

import com.pragma.store.chapter.infrastructure.persistence.dao.AssessmentScheduleCustomDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AssessmentScheduleDaoImpl implements AssessmentScheduleCustomDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public List<AssessmentScheduleEntity> holaMundo() {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
//
//        From assessmentScheduleEntitiesFrom = criteriaQuery.from(AssessmentScheduleEntity.class);
//
//        TypedQuery<AssessmentScheduleEntity> resultQuery = entityManager.createQuery(
//                criteriaQuery
//                        .select(
//                                assessmentScheduleEntitiesFrom
//                        )
//        );
//
//        List<AssessmentScheduleEntity> usuariosEntity = resultQuery.getResultList();
//    }
}
