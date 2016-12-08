package com.klevytska.swshop.registrator;

import com.klevytska.swshop.model.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by klevytska on 08.12.2016.
 */
@Stateless
public class ProductRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Product create(Product product){
        return entityManager.merge(product);
    }

    public Product update(Product product){
        return entityManager.merge(product);
    }

    public void delete(Product product){
        entityManager.remove(product);
    }
}
