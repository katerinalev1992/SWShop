package com.klevytska.swshop.rest;

import com.klevytska.swshop.model.Customer;
import com.klevytska.swshop.registrator.CustomerRegistrator;
import com.klevytska.swshop.repository.CustomerRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by klevytska on 12.12.2016.
 */
@Path("/customer/")
@RequestScoped
public class CustomerREST {

    @Inject
    private Logger logger;

    @Inject
    private CustomerRepository repository;

    @Inject
    private CustomerRegistrator registrator;

    @Inject
    private Validator validator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllTeams() {
        logger.info("GET all games");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer listById(@PathParam("id") long id) {
        return repository.getById(id);
    }

}
