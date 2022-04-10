package com.customer.tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.customer.tracker.entity.Customer;
@Repository
@Transactional
@EnableTransactionManagement
public class CustomerDAOImpl implements CustomerDAO {

	// Injecting Session Factory object
		@Autowired
		private SessionFactory sessionFactory;
	
	
		@Transactional
		public List<Customer> getAllCustomers() {
			Session currentSession = sessionFactory.getCurrentSession();
			// Craeting a Hibernate Query
			Query<Customer> createQuery = currentSession.createQuery("from Customer order by firstName",
					Customer.class);
			// Executing the Query to get the Result Set.
			List<Customer> allCustomers = createQuery.getResultList();
			return allCustomers;
		}

		public void saveCustomer(Customer customer) {
			// Getting Current Hibernate Session
			Session currentSession = sessionFactory.getCurrentSession();

			currentSession.saveOrUpdate(customer);

		}

		@Transactional
		public void deleteCustomerbyId(int Id) {
			// Getting Current Hibernate Session
			Session currentSession = sessionFactory.getCurrentSession();

			Query thequery = currentSession.createQuery("Delete from Customer where id=:customerId");

			thequery.setParameter("customerId", Id);

			thequery.executeUpdate();

		}

		public Customer getCustomerbyId(int Id) {
			// Getting Current Hibernate Session
			Session currentSession = sessionFactory.getCurrentSession();

			// Fetching data from the Databse as per given Customer Id.
			Customer customer = currentSession.get(Customer.class, Id);

			return customer;
		}

}
