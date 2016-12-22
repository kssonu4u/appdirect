package com.appdirect.entity;

import java.io.Serializable;

public class OrderDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5069210776517744121L;

	private String id;

	private Integer quantity;

	private String unit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
