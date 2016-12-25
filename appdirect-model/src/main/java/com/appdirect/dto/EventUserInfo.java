package com.appdirect.dto;

import java.util.Map;

/**
 * @author sauurav class for representing User Info from appdirect
 *
 */
public class EventUserInfo {

	private EventUserAddress address;

	private String email;

	private String firstName;

	private String language;

	private String lastName;

	private String openId;

	private String uuid;

	private Map<String, String> attributes;
	
	
	
	public EventUserInfo() {
		super();
	}

	public EventUserInfo(EventUserAddress address, String email, String firstName, String language, String lastName,
			String openId, String uuid) {
		super();
		this.address = address;
		this.email = email;
		this.firstName = firstName;
		this.language = language;
		this.lastName = lastName;
		this.openId = openId;
		this.uuid = uuid;
	}

	public EventUserAddress getAddress() {
		return address;
	}

	public void setAddress(EventUserAddress address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

}
