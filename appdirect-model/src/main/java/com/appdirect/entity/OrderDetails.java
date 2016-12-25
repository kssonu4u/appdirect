package com.appdirect.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author saurav class for representing order details of a particular
 *         subscription
 *
 */
@Document(collection = "order_details")
public class OrderDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3609838346463923494L;
	@Field("edition_code")
	private String editionCode;
	@Field
	private Integer quantity;
	@Field("pricing_duration")
	private String pricingDuration;
	@Field
	private String unit;
	@Field
	private List<Item> items;

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
