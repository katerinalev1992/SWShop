package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.Employee;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@Stateless
public class EmployeeRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Employee create(Employee employee){
        return entityManager.merge(employee);
    }

    public Employee update(Employee employee){
        return entityManager.merge(employee);
    }

    public void delete(Employee employee){
        entityManager.remove(employee);
    }
}
