package com.greatlearning.crm.dao;

import java.util.List;

import com.greatlearning.crm.model.Customer;

public interface CustomerDAO {

	public List<Customer> viewAllCustomer();

	public Customer findCustomerDetailsById(int id);

	public void saveCustomerDetails(Customer customer);

	public void deleteCustomerDetails(int id);

}
