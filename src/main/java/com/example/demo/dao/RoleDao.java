package com.example.demo.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RoleModel;
import com.example.demo.repo.RoleRepo;

@Repository
public class RoleDao {

	@Autowired
	private RoleRepo roleRepo;

	public void saveAll(List<RoleModel> entities) {
		roleRepo.saveAll(entities);
	}

	public List<RoleModel> findRoles(Collection<Integer> roleIds) {
		return roleRepo.findRoles(roleIds);
	}
}
