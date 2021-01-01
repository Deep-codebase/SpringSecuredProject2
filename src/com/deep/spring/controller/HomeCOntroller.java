package com.deep.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deep.spring.dao.CustomerDAO;
import com.deep.spring.entity.Customer;
import com.deep.spring.entity.Users;
import com.deep.spring.service.CustomerService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/customer")
public class HomeCOntroller {

    @Autowired
    private CustomerDAO customerDAO;
    
    @Autowired
    CustomerService cservice;

    @GetMapping("/list")
    public String listCustomers(Model theModel, HttpSession session) {
    	
        List<Customer> theCustomers = customerDAO.getCustomers();

        theModel.addAttribute("customers", theCustomers);
        
        Gson gson = new Gson();
		String json = gson.toJson(theCustomers);
		System.out.println(json);
		theModel.addAttribute("customertablejson", json);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String un = ((Users)principal).getName();
		String username = auth.getName();
		session.setAttribute("username", username);
        return "list-customers";
    }
    
    @GetMapping("/showFormForAdd")
    public String ShowAddForm(Model theModel) {
    	
    	Customer theCustomer = new Customer();
    	
    	theModel.addAttribute("customer", theCustomer);
    	
    	return "customer-form";
    }
    
    @PostMapping("/saveCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer theCustomer, Model model) {
    	cservice.saveCustomer(theCustomer);
    	model.addAttribute("successsaving", "Customer saved successfully");
    	return "customer-form";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        Customer theCustomer = customerDAO.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }
}
