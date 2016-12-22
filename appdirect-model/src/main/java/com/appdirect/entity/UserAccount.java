package com.appdirect.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_account")
public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1510384526539982466L;
	
	@Id
	@Field
	private String id;
	@Indexed
	@Field("account_identifier")
	private String accountIdentifier;

	private String appDirectBaseUrl;
	
	private Integer isActive = 1;
	
	private String status;

	private String uuid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String getAppDirectBaseUrl() {
		return appDirectBaseUrl;
	}

	public void setAppDirectBaseUrl(String appDirectBaseUrl) {
		this.appDirectBaseUrl = appDirectBaseUrl;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
