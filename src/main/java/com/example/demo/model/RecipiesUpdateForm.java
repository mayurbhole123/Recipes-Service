package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class RecipiesUpdateForm {

  @NotNull
  private String recepieName;

  @NotNull
  private String recepieType;

  @NotNull
  private Integer recepieServingLimit;

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

}
