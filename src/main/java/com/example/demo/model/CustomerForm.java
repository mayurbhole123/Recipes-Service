package com.example.demo.model;

import java.util.List;

/**
 * Form to store details that needs to send to view page.
 *
 */
public class CustomerForm {

  private Integer userId;
  private List<Integer> roleIds;
  private String userName;
  private String dateOfBirth;
  private String gender;
  private String phoneNumber;
  private boolean isReadOnly;

  public CustomerForm(Integer userId, List<Integer> roleIds, String userName, String dateOfBirth, String gender,
      String phoneNumber) {
    super();
    this.userId = userId;
    this.roleIds = roleIds;
    this.userName = userName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public List<Integer> getRoleId() {
    return roleIds;
  }

  public void setRoleId(List<Integer> roleIds) {
    this.roleIds = roleIds;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isReadOnly() {
    return isReadOnly;
  }

  public void setReadOnly(boolean isReadOnly) {
    this.isReadOnly = isReadOnly;
  }

}
