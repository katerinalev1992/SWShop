package com.klevytska.swshop.repository;

import com.klevytska.swshop.model.Order;

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
public class OrderRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public Order getById(Long id){
        logger.info("Get game by id: " + id);
        return entityManager.find(Order.class, id);
    }

    public List<Order> getAll(){
        CriteriaBuilder criteriaBuilder;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> element = criteriaQuery.from(Order.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
