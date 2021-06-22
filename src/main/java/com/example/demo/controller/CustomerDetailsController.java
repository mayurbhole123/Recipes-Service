package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwtConfig.WebSecurityConfig;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.RoleModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.RoleRepo;
import com.example.demo.service.CustomerService;
import com.example.demo.utilService.CommonUtilityService;

/**
 * Customer details controller user for having role based security on mappings.
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/")
public class CustomerDetailsController {

  @Autowired
  CustomerService customerService;

  @Autowired
  CommonUtilityService utilService;

  @Autowired
  private PasswordEncoder bcryptEncoder;

  @Autowired
  private CustomerRepo customerRepo;

  @Autowired
  EntityManager entityManager;

  @Autowired
  RoleRepo roleRepo;

  /**
   * This Api will create different access roles.
   * This Api is Open api & can be access by anyone. Authentication is allowed for this API.
   * Refer {@link WebSecurityConfig #configure}
   * 
   * @param roleModels
   * @return
   */
  @RequestMapping(value = "/insertRoles")
  public ResponseEntity<?> insertRoles(@RequestBody List<RoleModel> roleModels) {
    roleRepo.saveAll(roleModels);
    return ResponseEntity.ok("Roles saved successfully.");
  }

  /**
   * This method will save customer along with roles into table.
   * This Api is Open api & can be access by anyone. Authentication is allowed for this API.
   * Refer {@link WebSecurityConfig #configure}
   * 
   * @param user
   * @return
   * @throws Exception
   */
  @PostMapping(value = "/insertCustomer")
  public ResponseEntity<?> saveUser(@RequestBody CustomerModel user) throws Exception {
    user.setPassword(bcryptEncoder.encode(user.getPassword()));
    customerRepo.save(user);
    return ResponseEntity.ok("User saved successfully.");
  }

  /**
   * This method will fetch all customer details only if role is admin.
   * This Api will fetch all customer details.
   * 
   * @return
   */
  @PreAuthorize("hasRole('ROLE_admin')")
  @PostMapping(value = "/customerListingPage")
  public ResponseEntity<?> customerListing(HttpServletRequest request) {
    System.out.println(request.isUserInRole("ROLE_admin"));
    List<CustomerModel> customerList = customerRepo.findAll();
    return ResponseEntity.ok(customerList);
  }
}
