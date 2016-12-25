package com.appdirect.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author saurav class for representing items in a order for a particular
 *         subscription
 */
@Document(collection = "order_items")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4074919631692481958L;
	@Field
	private Integer quantity;
	@Field
	private String unit;

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
