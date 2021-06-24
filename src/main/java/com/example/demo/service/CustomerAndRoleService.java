package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.RoleModel;

@Service
public class CustomerAndRoleService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Transactional(rollbackOn = Exception.class)
	public void insertRoles(List<RoleModel> roleModels) {
		roleDao.saveAll(roleModels);
	}

	@Transactional(rollbackOn = Exception.class)
	public void saveUser(CustomerModel user) throws Exception {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		customerDao.save(user);
	}

	public List<CustomerModel> customerListing() {
		return customerDao.findAll();
	}

}
