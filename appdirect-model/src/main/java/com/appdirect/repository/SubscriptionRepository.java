package com.appdirect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.appdirect.entity.Subscription;

/**
 * @author saurav Repository for performing CRUD operations
 *
 */
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
	
	
	/**
	 * @param accountId
	 * @return full subscription object for a particular accountId
	 */
	public Subscription findById(String accountId);
	
	/**
	 * @param uuid
	 * @return full subscription object for a particular user uuid
	 */
	@Query("{'users.uuid' : ?0}")
	public Subscription findSubscriptionByUserId(String uuid);
}
