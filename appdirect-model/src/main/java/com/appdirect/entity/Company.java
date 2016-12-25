package com.appdirect.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author saurav class for representing company information of a particular
 *         subscription
 */
public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7988612079887159718L;

	@Field
	private String country;
	@Field
	private String name;
	@Field("phone_number")
	private String phoneNumber;
	@Field
	private String uuid;
	@Field
	private String website;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
