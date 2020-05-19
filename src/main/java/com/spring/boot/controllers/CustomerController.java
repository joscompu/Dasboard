package com.spring.boot.controllers;


import com.spring.boot.models.entity.Customer;
import com.spring.boot.models.service.ICustomerService;
import com.spring.boot.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Controller
@SessionAttributes("customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash){
        Customer customer = iCustomerService.findOne(id);
        if (customer == null){
            flash.addFlashAttribute("error","Customer does not exist in the database");
            return "redirect:/all";
        }

        model.put("customer",customer);
        model.put("title","Details Customer: " + customer.getName());
        return "view";
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String allCustomer(@RequestParam(name = "page",defaultValue = "0") int page, Model model){
        Pageable pageRequest = PageRequest.of(page,5);
        Page<Customer> customers = iCustomerService.findAll(pageRequest);
        PageRender<Customer> pageRender = new PageRender<>("/all",customers);
        model.addAttribute("title","All Customer");
        model.addAttribute("customers",customers);
        model.addAttribute("page",pageRender);
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
    public String saveCustomer(@Valid Customer customer, BindingResult result, Model model,
                               @RequestParam("file") MultipartFile photo, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()){
            model.addAttribute("title","New Customer");
            return "form";
        }

        if (!photo.isEmpty()){

            Path directoryResources = Paths.get("src//main//resources//static//uploads");
            String rootPath = directoryResources.toFile().getAbsolutePath();
            try {
                byte[] bytes = photo.getBytes();
                Path pathComplete = Paths.get(rootPath + "//" + photo.getOriginalFilename());
                Files.write(pathComplete,bytes);
                flash.addFlashAttribute("info","Image has been loaded '" + photo.getOriginalFilename() + "'");
                customer.setPhoto(photo.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
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
