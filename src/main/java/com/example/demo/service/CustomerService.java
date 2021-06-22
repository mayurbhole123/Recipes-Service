package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.CustomerModel;

/**
 * Interface having abstract method which will be implemented by service
 * implementation class.
 *
 */
public interface CustomerService {
	public void save(CustomerModel customer);

	public Optional<CustomerModel> findByCustomerId(int customerId);

	public ArrayList<CustomerModel> getAllCustomers();
}
