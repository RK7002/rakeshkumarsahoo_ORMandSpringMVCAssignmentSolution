package com.greatlearning.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.crm.model.Customer;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> viewAllCustomer() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> selectQuery = currentSession.createQuery("from Customer", Customer.class);
		return selectQuery.getResultList();
	}

	@Override
	@Transactional
	public void saveCustomerDetails(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer findCustomerDetailsById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, id);
	}

	@Override
	@Transactional
	public void deleteCustomerDetails(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(currentSession.get(Customer.class, id));
	}

}
