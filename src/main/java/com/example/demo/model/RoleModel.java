package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Role model class to communicate with db.
 *
 */
@Entity
@Table(name = "role_details")
public class RoleModel {

	@Id
	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "role_name")
	@NotNull
	private String roleName;

	@Column(name = "role_code")
	private String roleCode;

	public RoleModel(int roleId, String roleName, String roleCode) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
	}
	
	public RoleModel() {
		
	}
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
