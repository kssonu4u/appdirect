package com.appdirect.service;

import com.appdirect.entity.Subscription;

/**
 * @author saurav interface for handling all the actions related to a
 *         subscription
 *
 */
public interface SubscriptionService {

	public Subscription saveSubscription(Subscription account);

	public Subscription getSubscriptionById(String accountIdentifier);

	public void deleteSubscription(Subscription subscriptions);

	public Subscription getSubscriptionByUserId(String uuid);
}
