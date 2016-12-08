package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.OrderDetail;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@Stateless
public class OrderDetailRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public OrderDetail create(OrderDetail orderDetail){
        return entityManager.merge(orderDetail);
    }

    public OrderDetail update(OrderDetail orderDetail){
        return entityManager.merge(orderDetail);
    }

    public void delete(OrderDetail orderDetail){
        entityManager.remove(orderDetail);
    }
}
