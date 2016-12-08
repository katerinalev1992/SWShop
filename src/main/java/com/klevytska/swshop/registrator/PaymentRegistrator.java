package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.Payment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@Stateless
public class PaymentRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Payment create(Payment payment){
        return entityManager.merge(payment);
    }

    public Payment update(Payment payment){
        return entityManager.merge(payment);
    }

    public void delete(Payment payment){
        entityManager.remove(payment);
    }
}
