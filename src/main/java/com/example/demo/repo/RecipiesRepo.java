package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RecepiesModel;

@Repository
public interface RecipiesRepo extends JpaRepository<RecepiesModel, Integer>{

}
