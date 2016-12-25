package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.entity.Subscription;
import com.appdirect.repository.SubscriptionRepository;
import com.appdirect.service.SubscriptionService;

/**
 * @author saurav service for handling all the CRUD request for a particular
 *         subscription
 *
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Override
	public Subscription saveSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.save(subscription);
	}

	@Override
	public Subscription getSubscriptionById(String accountId) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(accountId);
	}

	@Override
	public void deleteSubscription(Subscription subscriptions) {
		// TODO Auto-generated method stub
		subscriptionRepository.delete(subscriptions);
	}

	@Override
	public Subscription getSubscriptionByUserId(String uuid) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findSubscriptionByUserId(uuid);
	}

}
