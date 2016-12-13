package com.klevytska.swshop.repository;

import com.klevytska.swshop.model.Payment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@ApplicationScoped
public class PaymentRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public Payment getById(Long id){
        logger.info("Get game by id: " + id);
        return entityManager.find(Payment.class, id);
    }

    public List<Payment> getAll(){
        CriteriaBuilder criteriaBuilder;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Payment.class);
        Root<Payment> element = criteriaQuery.from(Payment.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
