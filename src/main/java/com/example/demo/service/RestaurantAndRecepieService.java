package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RecipiesDao;
import com.example.demo.dao.RestaurantDao;
import com.example.demo.model.RecepiesModel;
import com.example.demo.model.RecipiesUpdateForm;
import com.example.demo.model.RestaurantModel;

@Service
public class RestaurantAndRecepieService {

	@Autowired
	private RestaurantDao restaurantDao;

	@Autowired
	private RecipiesDao recipiesDao;

	@Transactional(rollbackOn = Exception.class)
	public void insertRestaurantAndRecipes(RestaurantModel restaurantModel) {
		for (RecepiesModel model : restaurantModel.getRecepies()) {
			model.setCreatedDate(LocalDateTime.now());
		}
		restaurantDao.save(restaurantModel);
	}

	public List<RestaurantModel> getRestaurants() {
		return restaurantDao.findAll();
	}

	@Transactional(rollbackOn = Exception.class)
	public void insertRecipes(RecepiesModel recepiesModel) {
		recepiesModel.setCreatedDate(LocalDateTime.now());
		recipiesDao.save(recepiesModel);
	}

	public List<RecepiesModel> getRecipes() {
		return recipiesDao.findAll();
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean updateRecipes(int recipeId, RecipiesUpdateForm recipiesUpdateForm) {

		Optional<RecepiesModel> optionalRecepiesModel = recipiesDao.findById(recipeId);
		if (!optionalRecepiesModel.isPresent()) {
			return false;
		}

		RecepiesModel model = optionalRecepiesModel.get();
		model.setRecepieName(recipiesUpdateForm.getRecepieName());
		model.setRecepieType(recipiesUpdateForm.getRecepieType());
		model.setRecepieServingLimit(recipiesUpdateForm.getRecepieServingLimit());
		model.setCreatedDate(LocalDateTime.now());
		recipiesDao.save(model);
		return true;
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean deleteRecipes(int recipeId) {

		Optional<RecepiesModel> optionalRecepiesModel = recipiesDao.findById(recipeId);
		if (!optionalRecepiesModel.isPresent()) {
			return false;
		}

		recipiesDao.deleteById(recipeId);
		return true;
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean deleteRestaurants(int restauranId) {

		Optional<RestaurantModel> optionalRestaurantModel = restaurantDao.findById(restauranId);
		if (!optionalRestaurantModel.isPresent()) {
			return false;
		}

		restaurantDao.deleteById(restauranId);
		return true;
	}

}
