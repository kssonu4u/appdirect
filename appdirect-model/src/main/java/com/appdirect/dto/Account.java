package com.appdirect.dto;

/**
 * @author saurav class for representing account info object from appdirect
 *
 */
public class Account {

	private String accountIdentifier;

	private String status;

	public Account() {
		super();
	}

	public Account(String accountIdentifier, String status) {
		super();
		this.accountIdentifier = accountIdentifier;
		this.status = status;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
