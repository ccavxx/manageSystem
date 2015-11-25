package com.tmh.web.domain;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -578654691860294392L;
	private Integer id;
	private String username;
	private String password;
	private String salt;//随机数 不是真正用于加密的密钥 真正加密的是slat+name
	private String status;
	
	
	
	
	private String credentialsSalt;
	
	
	
	
	public String getCredentialsSalt() {
		return salt+username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
