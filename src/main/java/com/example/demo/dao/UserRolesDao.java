package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRolesModel;
import com.example.demo.repo.UserRolesRepo;

@Repository
public class UserRolesDao {

	@Autowired
	private UserRolesRepo userRolesRepo;

	public List<UserRolesModel> getUserRoles(Integer userId) {
		return userRolesRepo.getUserRoles(userId);
	}

}
