package com.spring.boot.controllers;

import com.spring.boot.models.dao.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerDao customerDao;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String allCustomer(Model model){
        model.addAttribute("title","List All Customer");
        model.addAttribute("customers",customerDao.findAll());
        return "all";
    }
}
