package com.neelkamal.dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.neelkamal.model.Customer;


public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	
	@Query("from Customer where address like ?1%")	
	public List<Customer> getByAddress(String address);
	
	@Query("from Customer where address=?1 order by name")
	public List<Customer> getByAddressSorted(String address);
}
