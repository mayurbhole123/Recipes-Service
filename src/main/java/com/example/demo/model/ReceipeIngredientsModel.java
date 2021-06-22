package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receipe_ingredients")
public class ReceipeIngredientsModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ingredient_id")
  private Integer ingredientId;

  @Column(name = "recepie_id")
  private Integer recepieId;

  @Column(name = "ingredient_name")
  private String ingredientName;

  @Column(name = "ingredient_quantity")
  private String ingredientQuantity;

  public Integer getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(Integer ingredientId) {
    this.ingredientId = ingredientId;
  }

  public Integer getRecepieId() {
    return recepieId;
  }

  public void setRecepieId(Integer recepieId) {
    this.recepieId = recepieId;
  }

  public String getIngredientName() {
    return ingredientName;
  }

  public void setIngredientName(String ingredientName) {
    this.ingredientName = ingredientName;
  }

  public String getIngredientQuantity() {
    return ingredientQuantity;
  }

  public void setIngredientQuantity(String ingredientQuantity) {
    this.ingredientQuantity = ingredientQuantity;
  }

}
