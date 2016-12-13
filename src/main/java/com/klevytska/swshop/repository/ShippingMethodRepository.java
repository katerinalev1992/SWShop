package com.klevytska.swshop.repository;

import com.klevytska.swshop.model.ShippingMethod;

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
public class ShippingMethodRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public ShippingMethod getById(Long id){
        logger.info("Get game by id: " + id);
        return entityManager.find(ShippingMethod.class, id);
    }

    public List<ShippingMethod> getAll(){
        CriteriaBuilder criteriaBuilder;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(ShippingMethod.class);
        Root<ShippingMethod> element = criteriaQuery.from(ShippingMethod.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
