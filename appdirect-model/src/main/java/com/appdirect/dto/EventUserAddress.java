package com.appdirect.dto;

/**
 * @author saurav class for representing User address from appdirect
 *
 */
public class EventUserAddress {
	private String firstName;

	private String fullName;

	private String lastName;

	private String city;

	private String country;

	private String state;

	private String street1;

	private String zip;

	private String street2;

	public EventUserAddress() {
		super();
	}

	public EventUserAddress(String firstName, String fullName, String lastName, String city, String country,
			String state, String street1, String zip, String street2) {
		super();
		this.firstName = firstName;
		this.fullName = fullName;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.state = state;
		this.street1 = street1;
		this.zip = zip;
		this.street2 = street2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}
}
