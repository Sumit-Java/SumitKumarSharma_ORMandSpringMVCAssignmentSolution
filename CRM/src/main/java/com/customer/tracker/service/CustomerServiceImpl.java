package com.customer.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.customer.tracker.dao.CustomerDAO;
import com.customer.tracker.entity.Customer;

@Service
@EnableTransactionManagement
public class CustomerServiceImpl implements CustomerService {
	// Auto Injecting Bean of CustomerDAO.	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public List<Customer> getAllCustomersDetails() {
		return customerDAO.getAllCustomers();
		
	}
	@Transactional
	public void createNewCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);

	}
	@Transactional
	public void deleteCustomerbyId(int Id) {
		customerDAO.deleteCustomerbyId(Id);

	}
	@Transactional
	public Customer getSingleCustomer(int Id) {
		return customerDAO.getCustomerbyId(Id);
		
	}

}
