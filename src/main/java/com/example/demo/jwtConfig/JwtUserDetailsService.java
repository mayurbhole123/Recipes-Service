package com.example.demo.jwtConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserRolesDao;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.RoleModel;
import com.example.demo.model.UserRolesModel;

/**
 * User service class to validate user is available or valid or not.
 *
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private UserRolesDao userRolesDao;

	@Autowired
	private RoleDao roleDao;

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<CustomerModel> user = customerDao.findByUserName(username);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUserName(),
				user.get().getPassword(), getAuthority(user.get()));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set getAuthority(CustomerModel customer) {
		Set authorities = new HashSet<>();
		List<UserRolesModel> userRoles = userRolesDao.getUserRoles(customer.getUserId());
		List<RoleModel> roles = roleDao
				.findRoles(userRoles.stream().map(UserRolesModel::getRoleId).collect(Collectors.toList()));

		for (RoleModel role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleCode()));
		}
		return authorities;
	}
}
