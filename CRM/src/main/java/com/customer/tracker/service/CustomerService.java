package com.customer.tracker.service;

import java.util.List;

import com.customer.tracker.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomersDetails();

	public void createNewCustomer(Customer customer);

	public void deleteCustomerbyId(int Id);

	public Customer getSingleCustomer(int Id);

}
