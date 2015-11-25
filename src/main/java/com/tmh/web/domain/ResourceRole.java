package com.tmh.web.domain;

import java.io.Serializable;

public class ResourceRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5471711169706660290L;
	private Integer id;
	private Integer resourceId;
	private Integer roleId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
