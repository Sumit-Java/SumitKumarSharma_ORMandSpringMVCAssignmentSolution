package com.customer.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CRM")
public class Customer {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name ="Id")
		private int id;

		@Column(name = "First_Name")
		private String firstName;

		@Column(name = "Last_name")
		private String lastName;

		@Column(name = "Email_Id")
		private String email;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Customer(int id, String firstName, String lastName, String email) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ "]";
		}
		
		
}
