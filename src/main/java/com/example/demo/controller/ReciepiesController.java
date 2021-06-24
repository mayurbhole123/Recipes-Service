package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RecepiesModel;
import com.example.demo.model.RecipiesUpdateForm;
import com.example.demo.model.RestaurantModel;
import com.example.demo.service.RestaurantAndRecepieService;

/**
 * This controller class is used to handle request & response for restaurant,
 * recipes entities.
 *
 */
@RestController
@CrossOrigin
public class ReciepiesController {

	@Autowired
	private RestaurantAndRecepieService restaurantAndRecepieService;

	/**
	 * This Api can only accessible for the customer who is having admin role. This
	 * will insert new restaurants & add recipes for it.
	 * 
	 * @param restaurantModel
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_admin')")
	@PostMapping(value = "/insertRestaurant&Recipes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertRestaurantAndRecipes(@RequestBody RestaurantModel restaurantModel) {
		restaurantAndRecepieService.insertRestaurantAndRecipes(restaurantModel);
		return new ResponseEntity<Object>("Restaurant And Recipes added successfully.", HttpStatus.OK);
	}

	/**
	 * This Api can only accessible for the customer who is having admin role.
	 * Method will return list of restaurants.
	 * 
	 * @return
	 */
	@PostMapping(value = "/getRestaurants")
	@PreAuthorize("hasRole('ROLE_admin')")
	public ResponseEntity<Object> getRestaurants() {
		return new ResponseEntity<Object>(restaurantAndRecepieService.getRestaurants(), HttpStatus.OK);
	}

	/**
	 * This Api can only accessible for the customer who is having admin or manager
	 * role. Api will insert recipes for particular restaurant.
	 * 
	 * @param recepiesModel
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_mgr')")
	@PostMapping(value = "/insertRecipes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertRecipes(@RequestBody RecepiesModel recepiesModel) {
		restaurantAndRecepieService.insertRecipes(recepiesModel);
		return new ResponseEntity<Object>("Recipes saved successfully", HttpStatus.OK);
	}

	/**
	 * This Api can only accessible for the customer who is having admin or manager
	 * role. This APi will fetch recipes of all the restaurant.
	 * 
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_mgr')")
	@PostMapping(value = "/getRecipes")
	public ResponseEntity<Object> getRecipes() {
		return new ResponseEntity<Object>(restaurantAndRecepieService.getRecipes(), HttpStatus.OK);
	}

	/**
	 * This Api can only accessible for the customer who is having admin or manager
	 * role. This APi will update only partial details of recipes of particular
	 * restaurant.
	 * 
	 * @param recipeId
	 * @param recipiesUpdateForm
	 * @return
	 */
	@PatchMapping(value = "/updateRecipes/{id}")
	@PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_mgr')")
	public ResponseEntity<Object> updateRecipes(@PathVariable("id") int recipeId,
			@RequestBody RecipiesUpdateForm recipiesUpdateForm) {
		if (!restaurantAndRecepieService.updateRecipes(recipeId, recipiesUpdateForm)) {
			return new ResponseEntity<Object>("Recipes update failed.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Recipes updated successfully.", HttpStatus.OK);
	}

	/**
	 * This Api can only accessible for the customer who is having admin role. This
	 * api will delete recipes.
	 * 
	 * @param recipeId
	 * @return
	 */
	@DeleteMapping(value = "/deleteRecipes/{id}")
	@PreAuthorize("hasRole('ROLE_admin')")
	public ResponseEntity<Object> deleteRecipes(@PathVariable("id") int recipeId) {
		if (!restaurantAndRecepieService.deleteRecipes(recipeId)) {
			return new ResponseEntity<Object>("Recipes delete failed.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Recipes deleted successfully.", HttpStatus.OK);
	}

	/**
	 * This Api can only accessible for the customer who is having admin role. This
	 * api will delete restaurants.
	 * 
	 * @param restauranId
	 * @return
	 */
	@DeleteMapping(value = "/deleteRestaurants/{id}")
	@PreAuthorize("hasRole('ROLE_admin')")
	public ResponseEntity<Object> deleteRestaurants(@PathVariable("id") int restauranId) {
		if (!restaurantAndRecepieService.deleteRestaurants(restauranId)) {
			return new ResponseEntity<Object>("Restaurant delete failed.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Restaurant deleted successfully.", HttpStatus.OK);
	}
}
