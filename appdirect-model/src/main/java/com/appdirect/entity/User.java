package com.appdirect.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class User {
	
	@Field("first_name")
	private String firstName;
	@Field("last_name")
	private String lastName;
	@Field("email")
	private String email;
	@Field
	private String language;
	@Field("open_id")
	private String openId;
	@Field
	private String uuid;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
