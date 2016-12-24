package com.appdirect.service;

import com.appdirect.entity.Subscriptions;

public interface SubscriptionService {
	public Subscriptions saveSubscription(Subscriptions account);

	public Subscriptions getSubscriptionById(String accountIdentifier);

	public void deleteSubscription(Subscriptions subscriptions);

	public Subscriptions getSubscriptionByUserId(String uuid);
}
