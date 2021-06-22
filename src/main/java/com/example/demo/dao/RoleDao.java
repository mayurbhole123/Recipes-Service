package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.RoleModel;

/**
 * Interface having abstract method which needs to implement in dao
 * implementation classes.
 *
 */
@Service
public interface RoleDao {
	public Optional<RoleModel> findByRoleId(int roleId);

	public List<RoleModel> findAllRoles();
}
