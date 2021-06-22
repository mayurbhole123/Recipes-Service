package com.example.demo.model;

import java.time.LocalDateTime;
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
@Table(name = "recepies")
public class RecepiesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "recepie_id")
  private Integer recepieId;

  @Column(name = "restaurant_id")
  private Integer restaurantId;

  @Column(name = "recepie_name")
  private String recepieName;

  @Column(name = "recepie_type")
  private String recepieType;

  @Column(name = "recepie_serving_limit")
  private Integer recepieServingLimit;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @Column(name = "recepie_cooking_nstruction")
  private String recepieCookingInstruction;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ReceipeIngredientsModel.class)
  @JoinColumn(name = "recepie_id", referencedColumnName = "recepie_id")
  private List<ReceipeIngredientsModel> ingredients;

  public Integer getRecepieId() {
    return recepieId;
  }

  public void setRecepieId(Integer recepieId) {
    this.recepieId = recepieId;
  }

  public Integer getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(Integer restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getRecepieName() {
    return recepieName;
  }

  public void setRecepieName(String recepieName) {
    this.recepieName = recepieName;
  }

  public String getRecepieType() {
    return recepieType;
  }

  public void setRecepieType(String recepieType) {
    this.recepieType = recepieType;
  }

  public Integer getRecepieServingLimit() {
    return recepieServingLimit;
  }

  public void setRecepieServingLimit(Integer recepieServingLimit) {
    this.recepieServingLimit = recepieServingLimit;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getRecepieCookingInstruction() {
    return recepieCookingInstruction;
  }

  public void setRecepieCookingInstruction(String recepieCookingInstruction) {
    this.recepieCookingInstruction = recepieCookingInstruction;
  }

  public List<ReceipeIngredientsModel> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<ReceipeIngredientsModel> ingredients) {
    this.ingredients = ingredients;
  }

}
