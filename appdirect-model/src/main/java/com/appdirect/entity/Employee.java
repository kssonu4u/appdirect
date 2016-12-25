package com.appdirect.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author saurav class for persisting employee object
 *
 */
public class Employee {

	@Id
	@Field
	private String id;

	@Field
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	

}
