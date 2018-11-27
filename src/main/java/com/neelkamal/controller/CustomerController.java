package com.neelkamal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.neelkamal.model.Customer;
import com.neelkamal.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer-list")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/edit-customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/add-customer")
	public Map<String, String> addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("message", "User is added");
		return messages;
	}
	
	@PutMapping("/update-customer")
	public  Map<String, String> updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("message", "User is updated");
		return messages;
	}
	
	
	@DeleteMapping("/delete-customer/{id}")
	public  Map<String, String> deleteCustomer(@PathVariable("id") int id) {
		
		customerService.deleteCustomerById(id);
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("message", "User is deleted");
		return messages;
	}
	
	@GetMapping("/search-customer")
	public List<Customer> searchCustomerByAddress(@RequestParam String address) {
		return customerService.getCustomerByAddress(address);
	}

}
