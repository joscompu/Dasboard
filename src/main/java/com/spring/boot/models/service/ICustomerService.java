package com.spring.boot.models.service;

import com.spring.boot.models.entity.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Customer> findAll();
    public void save(Customer customer);
    public Customer findOne(Long id);
    public void delete(Long id);
}
