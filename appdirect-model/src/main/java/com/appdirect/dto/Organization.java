package com.appdirect.dto;

/**
 * @author saurav class for representing Company information
 *
 */
public class Organization {

	private String country;
	private String name;
	private String uuid;
	private String website;
	private String phoneNumber;

	public Organization(String country, String name, String uuid, String website, String phoneNumber) {
		super();
		this.country = country;
		this.name = name;
		this.uuid = uuid;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
