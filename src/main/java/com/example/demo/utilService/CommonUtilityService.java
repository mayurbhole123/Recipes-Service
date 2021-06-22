package com.example.demo.utilService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerForm;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.RoleModel;
import com.example.demo.model.UserRolesModel;
import com.example.demo.repo.UserRolesRepo;
import com.example.demo.service.CustomerService;

/**
 * Util service class for populating customer details into form.
 *
 */
@Service
public class CommonUtilityService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserRolesRepo userRolesRepo;

	/**
	 * get form to send to view page
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception 
	 */
  public CustomerForm getCustomerDetailsForm(Integer customerId) throws Exception {
    if (customerId == null) {
      return new CustomerForm(null, null, null, null, null, null);
    }
    CustomerModel customerModel = customerService.findByCustomerId(customerId).orElseThrow(Exception::new);

    List<UserRolesModel> userRoles = userRolesRepo.getUserRoles(customerModel.getUserId());

    List<Integer> roleIds = userRoles.stream().map(UserRolesModel::getRoleId).collect(Collectors.toList());

    return new CustomerForm(customerModel.getUserId(), roleIds, customerModel.getUserName(),
        customerModel.getDateOfBirth().toString(), customerModel.getGender(), customerModel.getPhoneNumber());

  }
}
