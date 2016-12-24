package com.appdirect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.appdirect.entity.Subscriptions;

public interface SubscriptionRepository extends MongoRepository<Subscriptions, String> {

	public Subscriptions findById(String accountId);
	
	@Query("{'users.uuid' : ?0}")
	public Subscriptions findSubscriptionByUserId(String uuid);
}
