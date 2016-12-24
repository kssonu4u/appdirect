package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.entity.Subscriptions;
import com.appdirect.repository.SubscriptionRepository;
import com.appdirect.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Override
	public Subscriptions saveSubscription(Subscriptions subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.save(subscription);
	}
	@Override
	public Subscriptions getSubscriptionById(String accountId) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(accountId);
	}
	@Override
	public void deleteSubscription(Subscriptions subscriptions) {
		// TODO Auto-generated method stub
		subscriptionRepository.delete(subscriptions);
	}
	@Override
	public Subscriptions getSubscriptionByUserId(String uuid) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findSubscriptionByUserId(uuid);
	}

}
