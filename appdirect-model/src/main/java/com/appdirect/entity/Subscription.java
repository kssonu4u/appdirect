package com.appdirect.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.appdirect.appdirectdto.type.SubscriptionStatus;

/**
 * @author covacsis class for representing subscription
 *
 */
public class Subscription implements Serializable {

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
	@Field("base_url")
	private String baseUrl;
	@Field
	private String partner;
	@Field("subscription_status")
	private SubscriptionStatus subscriptionStatus;
	@Field("notice_type")
	private String noticeType;
	@Field
	private List<User> users;
	@Field
	private Company company;
	@Field("order_details")
	private OrderDetails orderDetails;

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

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

}
