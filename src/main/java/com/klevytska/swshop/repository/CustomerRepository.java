package com.klevytska.swshop.repository;

import com.klevytska.swshop.model.Customer;

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
public class CustomerRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public Customer getById(Long id){
        logger.info("Get game by id: " + id);
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> getAll(){
        CriteriaBuilder criteriaBuilder;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> element = criteriaQuery.from(Customer.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

//    public List<Customer> getById(Long id) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//        Root<Customer> element = criteriaQuery.from(Customer.class);
//        criteriaQuery.select(element).where(criteriaBuilder.equal(element.get("id"), id));
//        return entityManager.createQuery(criteriaQuery).getResultList();
//    }

}
