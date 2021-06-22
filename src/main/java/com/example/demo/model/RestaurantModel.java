package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class RestaurantModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "restaurant_id")
  private Integer restaurantId;

  @Column(name = "name")
  private String restaurantName;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = RecepiesModel.class)
  @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
  private List<RecepiesModel> recepies;

  public Integer getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(Integer restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public List<RecepiesModel> getRecepies() {
    return recepies;
  }

  public void setRecepies(List<RecepiesModel> recepies) {
    this.recepies = recepies;
  }
  
  
}
