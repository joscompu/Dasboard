package com.spring.boot.models.dao;

import com.spring.boot.models.entity.Customer;

import java.util.List;

public interface ICustomerDao {

    public List<Customer> findAll();
    public void save(Customer customer);
    public Customer findOne(Long id);
}
