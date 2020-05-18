package com.spring.boot.controllers;

import com.spring.boot.models.dao.ICustomerDao;
import com.spring.boot.models.entity.Customer;
import com.spring.boot.models.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String allCustomer(Model model){
        model.addAttribute("title","All Customer");
        model.addAttribute("customers",iCustomerService.findAll());
        return "all";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String addCustomer(Map<String, Object> model){
        Customer customer = new Customer();
        model.put("customer",customer);
        model.put("title","New Customer");
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editCustomer(@PathVariable Long id, Map<String,Object> model, RedirectAttributes flash){
        Customer customer = null;
        if (id>0){
            customer = iCustomerService.findOne(id);
            if (customer == null){
                flash.addFlashAttribute("error","The customer does not exist in the database");
                return "redirect:/all";
            }
        }else {
            flash.addFlashAttribute("error","The customer cannot have id 0");
            return "redirect:/all";
        }
        model.put("customer",customer);
        model.put("title","Edit Customer");
        return "form";
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String saveCustomer(@Valid Customer customer, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()){
            model.addAttribute("title","New Customer");
            return "form";
        }
        String mensaggeFlash = (customer.getId() != null)? "Customer successfully edited" : "Customer created successfully";
        iCustomerService.save(customer);
        status.setComplete();
        flash.addFlashAttribute("success",mensaggeFlash);
        return "redirect:all";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable Long id , RedirectAttributes flash){
        if (id>0){
            iCustomerService.delete(id);
            flash.addFlashAttribute("success","Customer successfully removed");
        }
        return "redirect:/all";
    }
}
