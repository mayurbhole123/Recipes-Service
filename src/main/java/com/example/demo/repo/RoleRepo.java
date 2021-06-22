package com.example.demo.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RoleModel;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Integer>{

  @Query(value = "SELECT r FROM RoleModel r WHERE r.roleId IN :roleIds")
  List<RoleModel> findRoles(@Param("roleIds") Collection<Integer> roleIds);
  
}
