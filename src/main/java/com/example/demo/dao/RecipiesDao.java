package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RecepiesModel;
import com.example.demo.repo.RecipiesRepo;

@Repository
public class RecipiesDao {

	@Autowired
	private RecipiesRepo recipiesRepo;

	public List<RecepiesModel> findAll() {
		return recipiesRepo.findAll();
	}

	public void save(RecepiesModel entity) {
		recipiesRepo.save(entity);
	}

	public Optional<RecepiesModel> findById(int id) {
		return recipiesRepo.findById(id);
	}

	public void deleteById(int id) {
		recipiesRepo.deleteById(id);
	}

}
