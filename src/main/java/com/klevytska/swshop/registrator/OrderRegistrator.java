package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.Order;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@Stateless
public class OrderRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Order create(Order order){
        return entityManager.merge(order);
    }

    public Order update(Order order){
        return entityManager.merge(order);
    }

    public void delete(Order order){
        entityManager.remove(order);
    }
}
