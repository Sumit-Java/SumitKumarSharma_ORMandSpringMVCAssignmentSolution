package com.customer.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.tracker.entity.Customer;
import com.customer.tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// Auto Injecting Bean for CustomerService to the Controller class.
	@Autowired
	private CustomerService customerService;

	//Fetching List of Customers using Model Object having GetMapping.
	@GetMapping("/list")
	public String customerList(Model model) {
		List<Customer> allCustomersDetails = customerService.getAllCustomersDetails();

		// Sending Data to the UI using Model Object

		model.addAttribute("listcustomer", allCustomersDetails);

		return "Customer-list";
	}
	// Accepting inputs and creating a customer object
	@GetMapping("/showFormForAdd")
	public String ShowFormForAdd(Model model, Customer customer) {
		//customerService.createNewCustomer(customer);
		model.addAttribute("theCustomer", customer);
		return "customer-form";
	}
	// First Receiving the input as an Object using @modelAttribute and Saving Data to the 
	//backend controller using PostMapping
	@PostMapping("/save")
	public String SaveCustomer(@ModelAttribute("customer") Customer thecustomer) {
		customerService.createNewCustomer(thecustomer);
		return "redirect:/customer/list";
	}
	//Accepting input Using @RequestParam as to update the existing Record.
	@GetMapping("/showFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer singleCustomer = customerService.getSingleCustomer(id);
		model.addAttribute("customer", singleCustomer);
		return "customer-form";
	}
	//Accepting input Using @RequestParam as to Delete the existing Record.
	@GetMapping("/delete")
	public String deletecustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomerbyId(id);
		return "redirect:/customer/list";
	}


	
}
