package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crm.dao.CustomerDAO;
import com.greatlearning.crm.model.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> viewAllCustomer() {
		return customerDAO.viewAllCustomer();
	}

	@Override
	public void saveCustomerDetails(Customer customer) {
		customerDAO.saveCustomerDetails(customer);
	}

	@Override
	public Customer findCustomerDetailsById(int id) {
		return customerDAO.findCustomerDetailsById(id);
	}

	@Override
	public void deleteCustomerDetails(int id) {
		customerDAO.deleteCustomerDetails(id);
	}

}
