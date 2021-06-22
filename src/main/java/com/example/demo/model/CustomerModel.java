package com.example.demo.model;

import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;

/**
 * Customer model class to communicate with db.
 *
 */
@Entity
@Table(name = "customer_details")
public class CustomerModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Integer userId;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = UserRolesModel.class)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private List<UserRolesModel> userRoles;

  @Column(name = "password")
  @NotNull
  private String password;

  @Column(name = "username")
  private String userName;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "gender")
  @NotNull
  private String gender;

  @Column(name = "phone_number")
  private String phoneNumber;

  public CustomerModel(int userId, List<UserRolesModel> userRoles, String userName, LocalDate dateOfBirth,
      @NotNull String gender, String phoneNumber) {
    super();
    this.userId = userId;
    this.userRoles = userRoles;
    this.userName = userName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
  }

  public CustomerModel() {

  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public List<UserRolesModel> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<UserRolesModel> userRoles) {
    this.userRoles = userRoles;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
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

  @Override
  public String toString() {
    return "CustomerModel [userId=" + userId + ", userRoles=" + userRoles + ", password=" + password + ", userName="
        + userName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phoneNumber=" + phoneNumber + "]";
  }

}
