package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.ShippingMethod;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */

@Stateless
public class ShippingMethodRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public ShippingMethod create(ShippingMethod shippingMethod){
        return entityManager.merge(shippingMethod);
    }

    public ShippingMethod update(ShippingMethod shippingMethod){
        return entityManager.merge(shippingMethod);
    }

    public void delete(ShippingMethod shippingMethod){
        entityManager.remove(shippingMethod);
    }

}
