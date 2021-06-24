package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRolesModel;

@Repository
public interface UserRolesRepo extends JpaRepository<UserRolesModel, Integer>{

	@Query("SELECT r FROM UserRolesModel r WHERE r.userId = ?1")
	List<UserRolesModel> getUserRoles(Integer userId);

}
