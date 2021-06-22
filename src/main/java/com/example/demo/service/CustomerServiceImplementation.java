package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.CustomerModel;

/**
 * Service implementation class used to invoke dao queries.
 *
 */
@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void save(CustomerModel customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	@Override
	public ArrayList<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public Optional<CustomerModel> findByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.findByCustomerId(customerId);
	}

}
