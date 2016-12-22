package com.appdirect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.appdirect.entity.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

	public UserAccount findByAccountIdentifier(String accountIdentifier);
}
