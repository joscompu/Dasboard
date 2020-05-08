package com.spring.boot.models.dao;

import com.spring.boot.models.entity.Customer;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Customer> findAll() {

        return em.createQuery("from Customer").getResultList();
    }


    @Override
    public Customer findOne(Long id) {
        return em.find(Customer.class, id);
    }


    @Override
    public void save(Customer customer) {
        if (customer.getId() != null && customer.getId() > 0) {
            em.merge(customer);
        } else {
            em.persist(customer);
        }

    }

    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
