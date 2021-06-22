package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Optional;

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
import com.example.demo.repo.RecepiesRepo;
import com.example.demo.repo.RestaurantRepo;

/**
 * This controller class is used to handle request & response for restaurant, recipes entities.
 *
 */
@RestController
@CrossOrigin
public class ReciepiesController {

  @Autowired
  RestaurantRepo restaurantRepo;

  @Autowired
  RecepiesRepo recepiesRepo;

  /**
   * This Api can only accessible for the customer who is having admin role.
   * This will insert new restaurants & add recipes for it.
   * 
   * @param restaurantModel
   * @return
   */
  @SuppressWarnings("unused")
  @PreAuthorize("hasRole('ROLE_admin')")
  @PostMapping(value = "/insertRestaurant&Recipes", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> insertRestaurantAndRecipes(@RequestBody RestaurantModel restaurantModel) {
    for (RecepiesModel model : restaurantModel.getRecepies()) {
      model.setCreatedDate(LocalDateTime.now());
    }
    restaurantRepo.save(restaurantModel);
    return new ResponseEntity<Object>(restaurantRepo.findAll(), HttpStatus.OK);
  }

  /**
   *  This Api can only accessible for the customer who is having admin role.
   *  Method will return list of restaurants.
   * 
   * @return
   */
  @SuppressWarnings("unused")
  @PostMapping(value = "/getRestaurants")
  @PreAuthorize("hasRole('ROLE_admin')")
  public ResponseEntity<Object> getRestaurants() {
    return new ResponseEntity<Object>(restaurantRepo.findAll(), HttpStatus.OK);
  }

  /**
   * This Api can only accessible for the customer who is having admin or manager role.
   * Api will insert recipes for particular restaurant.
   * 
   * @param recepiesModel
   * @return
   */
  @SuppressWarnings("unused")
  @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_mgr')")
  @PostMapping(value = "/insertRecipes", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> insertRecipes(@RequestBody RecepiesModel recepiesModel) {
    recepiesModel.setCreatedDate(LocalDateTime.now());
    recepiesRepo.save(recepiesModel);
    return new ResponseEntity<Object>("Recipes saved successfully", HttpStatus.OK);
  }

  /**
   * This Api can only accessible for the customer who is having admin or manager role.
   * This APi will fetch recipes of all the restaurant.
   * 
   * @return
   */
  @SuppressWarnings("unused")
  @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_mgr')")
  @PostMapping(value = "/getRecipes")
  public ResponseEntity<Object> getRecipes() {
    return new ResponseEntity<Object>(recepiesRepo.findAll(), HttpStatus.OK);
  }

  /**
   * This Api can only accessible for the customer who is having admin or manager role.
   * This APi will update only partial details of recipes of particular restaurant.
   * 
   * @param recipeId
   * @param recipiesUpdateForm
   * @return
   */
  @SuppressWarnings("unused")
  @PatchMapping(value = "/updateRecipes/{id}")
  @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_mgr')")
  public ResponseEntity<Object> updateRecipes(@PathVariable("id") int recipeId,
      @RequestBody RecipiesUpdateForm recipiesUpdateForm) {

    Optional<RecepiesModel> optionalRecepiesModel = recepiesRepo.findById(recipeId);
    if (!optionalRecepiesModel.isPresent()) {
      return new ResponseEntity<Object>("Recipes update failed.", HttpStatus.OK);
    }

    RecepiesModel model = optionalRecepiesModel.get();
    model.setRecepieName(recipiesUpdateForm.getRecepieName());
    model.setRecepieType(recipiesUpdateForm.getRecepieType());
    model.setRecepieServingLimit(recipiesUpdateForm.getRecepieServingLimit());
    model.setCreatedDate(LocalDateTime.now());
    recepiesRepo.save(model);
    return new ResponseEntity<Object>("Recipes updated successfully.", HttpStatus.OK);
  }

  /**
   * This Api can only accessible for the customer who is having admin role.
   * This api will delete recipes.
   * 
   * @param recipeId
   * @return
   */
  @SuppressWarnings("unused")
  @DeleteMapping(value = "/deleteRecipes/{id}")
  @PreAuthorize("hasRole('ROLE_admin')")
  public ResponseEntity<Object> deleteRecipes(@PathVariable("id") int recipeId) {

    Optional<RecepiesModel> optionalRecepiesModel = recepiesRepo.findById(recipeId);
    if (!optionalRecepiesModel.isPresent()) {
      return new ResponseEntity<Object>("Recipes delete failed.", HttpStatus.OK);
    }

    recepiesRepo.deleteById(recipeId);
    return new ResponseEntity<Object>("Recipes deleted successfully.", HttpStatus.OK);
  }

  /**
   * This Api can only accessible for the customer who is having admin role.
   * This api will delete restaurants.
   * 
   * @param restauranId
   * @return
   */
  @SuppressWarnings("unused")
  @DeleteMapping(value = "/deleteRestaurants/{id}")
  @PreAuthorize("hasRole('ROLE_admin')")
  public ResponseEntity<Object> deleteRestaurants(@PathVariable("id") int restauranId) {

    Optional<RestaurantModel> optionalRestaurantModel = restaurantRepo.findById(restauranId);
    if (!optionalRestaurantModel.isPresent()) {
      return new ResponseEntity<Object>("Restaurant delete failed.", HttpStatus.OK);
    }

    restaurantRepo.deleteById(restauranId);
    return new ResponseEntity<Object>("Restaurant deleted successfully.", HttpStatus.OK);
  }
}
