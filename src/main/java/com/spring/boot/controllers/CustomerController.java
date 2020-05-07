package com.spring.boot.controllers;

import com.spring.boot.models.dao.ICustomerDao;
import com.spring.boot.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerDao customerDao;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String allCustomer(Model model){
        model.addAttribute("title","All Customer");
        model.addAttribute("customers",customerDao.findAll());
        return "all";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String addCustomer(Map<String, Object> model){
        Customer customer = new Customer();
        model.put("customer",customer);
        model.put("title","New Customer");
        return "form";
    }
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String saveCustomer(@Valid Customer customer, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("title","New Customer");
            return "form";
        }
        customerDao.save(customer);
        return "redirect:all";
    }
}
