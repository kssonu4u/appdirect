package com.appdirect.dto;

import com.appdirect.appdirectdto.type.PriceUnit;

/**
 * @author saurav class for representing order items from appdirect
 *
 */
public class OrderItem {

	private Integer quantity;

	private PriceUnit unit;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer quantity, PriceUnit unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public PriceUnit getUnit() {
		return unit;
	}

	public void setUnit(PriceUnit unit) {
		this.unit = unit;
	}
}
