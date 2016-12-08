package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@Stateless
public class CustomerRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Customer create(Customer customer){
        return entityManager.merge(customer);
    }

    public Customer update(Customer customer){
        return entityManager.merge(customer);
    }

    public void delete(Customer customer){
        entityManager.remove(customer);
    }
}
