package com.customer.tracker.dao;

import java.util.List;

import com.customer.tracker.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public void deleteCustomerbyId(int Id);

	public Customer getCustomerbyId(int Id);


}
