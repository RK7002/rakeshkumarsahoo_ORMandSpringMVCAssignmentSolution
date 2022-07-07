package com.greatlearning.crm.service;

import java.util.List;
import com.greatlearning.crm.model.Customer;

public interface CustomerService {

	public List<Customer> viewAllCustomer();

	public Customer findCustomerDetailsById(int id);

	public void saveCustomerDetails(Customer customer);

	public void deleteCustomerDetails(int id);

}
