package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RestaurantModel;
import com.example.demo.repo.RestaurantRepo;

@Repository
public class RestaurantDao {

	@Autowired
	private RestaurantRepo restaurantRepo;

	public List<RestaurantModel> findAll() {
		return restaurantRepo.findAll();
	}

	public void save(RestaurantModel entity) {
		restaurantRepo.save(entity);
	}

	public Optional<RestaurantModel> findById(int id) {
		return restaurantRepo.findById(id);
	}

	public void deleteById(int id) {
		restaurantRepo.deleteById(id);
	}
}
