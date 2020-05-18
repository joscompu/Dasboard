package com.spring.boot.models.service;

import com.spring.boot.models.dao.ICustomerDao;
import com.spring.boot.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao iCustomerDao;


    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) iCustomerDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerDao.findAll(pageable);
    }


    @Transactional
    @Override
    public void save(Customer customer) {
        iCustomerDao.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findOne(Long id) {
        return iCustomerDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        iCustomerDao.deleteById(id);
    }
}
