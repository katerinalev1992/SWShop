package com.klevytska.swshop.repository;

import com.klevytska.swshop.model.Employee;

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
public class EmployeeRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public Employee getById(Long id){
        logger.info("Get game by id: " + id);
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> getAll(){
        CriteriaBuilder criteriaBuilder;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> element = criteriaQuery.from(Employee.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
