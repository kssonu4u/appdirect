package com.appdirect.dto;

import java.util.List;

import com.appdirect.appdirectdto.type.PriceDuration;

/**
 * @author saurav class for representing order information from apdirect
 *
 */
public class Order {
	
	private String editionCode;

	private PriceDuration pricingDuration;

	private List<OrderItem> items;
	
	public Order() {
		super();
	}

	public Order(String editionCode, PriceDuration pricingDuration, List<OrderItem> items) {
		super();
		this.editionCode = editionCode;
		this.pricingDuration = pricingDuration;
		this.items = items;
	}

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public PriceDuration getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(PriceDuration pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

}
