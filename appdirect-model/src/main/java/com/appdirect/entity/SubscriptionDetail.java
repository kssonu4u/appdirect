package com.appdirect.entity;

import java.io.Serializable;

public class SubscriptionDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4105445033811920339L;

	private String id;

	private String editionCode;

	private String pricingDuration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public String getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	
	
}
