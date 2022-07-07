package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String viewAllCustomer(Model model) {
		List<Customer> customers = customerService.viewAllCustomer();
		model.addAttribute("Customers", customers);
		return "viewallcustomer";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("addOrUpdateCustomer") Customer customer) {
		customerService.saveCustomerDetails(customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/showNewForm")
	public String showFormForSave(Model model) {
		Customer customer = new Customer();
		model.addAttribute("addOrUpdateCustomer", customer);
		return "viewForm";
	}

	@RequestMapping("/showUpdateForm")
	public String showFormForUpdate(Model model, @RequestParam("id") int id) {
		Customer customer = customerService.findCustomerDetailsById(id);
		model.addAttribute("addOrUpdateCustomer", customer);
		return "viewForm";
	}

	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) {
		customerService.deleteCustomerDetails(id);
		return "redirect:/customer/list";
	}
}
