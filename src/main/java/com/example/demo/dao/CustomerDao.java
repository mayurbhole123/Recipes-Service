package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerModel;
import com.example.demo.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo customerRepo;

	public List<CustomerModel> findAll() {
		return customerRepo.findAll();
	}

	public Optional<CustomerModel> findByUserName(String userName) {
		return customerRepo.findByUserName(userName);
	}

	public List<CustomerModel> findAllCustomers() {
		return customerRepo.findAllCustomers();
	}

	public void save(CustomerModel entity) {
		customerRepo.save(entity);
	}
}
