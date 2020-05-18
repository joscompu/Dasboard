package com.spring.boot.models.service;

import com.spring.boot.models.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    public List<Customer> findAll();
    public Page<Customer> findAll(Pageable pageable);
    public void save(Customer customer);
    public Customer findOne(Long id);
    public void delete(Long id);
}
