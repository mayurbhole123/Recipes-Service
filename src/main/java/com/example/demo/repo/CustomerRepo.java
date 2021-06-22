package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Integer>{
	public Optional<CustomerModel> findByUserName(String userName);
	
	@Query("from CustomerModel c join c.userRoles r where r.userId = c.userId")
  List<CustomerModel> findAllCustomers();
}
