package com.spring.boot.models.dao;


import com.spring.boot.models.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDao extends CrudRepository<Customer,Long> {
}
