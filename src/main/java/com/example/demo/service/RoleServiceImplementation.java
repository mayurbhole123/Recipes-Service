package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.RoleDao;
import com.example.demo.model.RoleModel;

/**
 * Service implementation class used to invoke dao queries.
 *
 */
@Service
@Transactional
public class RoleServiceImplementation implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public Optional<RoleModel> findByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return roleDao.findByRoleId(roleId);
	}

	@Override
	public List<RoleModel> findAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.findAllRoles();
	}

}
