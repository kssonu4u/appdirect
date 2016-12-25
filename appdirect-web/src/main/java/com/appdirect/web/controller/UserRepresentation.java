package com.appdirect.web.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRepresentation  {
	private String username;
	private String password;
	

	@JsonProperty("username")
    public String getUsername() {
    	return username;
    }
    @JsonProperty("username")
    public void setUsername(String username) {
    	this.username = username;
    }
    @JsonProperty("password")
    @JsonIgnore
	public String getPassword() {
		return password;
	}
    
    @JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}
   
}

