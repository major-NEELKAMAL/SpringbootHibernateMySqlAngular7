package com.neelkamal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neelkamal.dao.CustomerDAO;
import com.neelkamal.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public List<Customer> getAllCustomer(){
		return customerDAO.findAll();
	}
	
	@Transactional
	public Optional<Customer> getCustomerById(int id){
		return customerDAO.findById(id);
	}
	
	@Transactional
	public Customer addCustomer(Customer customer){
		return customerDAO.save(customer);
	}
	
	@Transactional
	public Customer updateCustomer(Customer customer){
		return customerDAO.save(customer);
	}
	
	@Transactional
	public void deleteCustomerById(int id){
		 customerDAO.deleteById(id);
	}
	
	@Transactional
	public List<Customer> getCustomerByAddress(String address){
		return customerDAO.getByAddress(address);
	}
}
