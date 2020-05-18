package com.spring.boot.models.dao;


import com.spring.boot.models.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerDao extends PagingAndSortingRepository<Customer,Long> {
}
