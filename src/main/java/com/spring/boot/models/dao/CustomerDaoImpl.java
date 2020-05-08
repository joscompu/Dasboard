package com.spring.boot.models.dao;

import com.spring.boot.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAll() {

        return em.createQuery("from Customer").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findOne(Long id) {
        return em.find(Customer.class, id);
    }

    @Transactional
    @Override
    public void save(Customer customer) {
        if (customer.getId() != null && customer.getId() > 0) {
            em.merge(customer);
        } else {
            em.persist(customer);
        }

    }
  @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
