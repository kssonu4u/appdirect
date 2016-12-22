package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.entity.UserAccount;
import com.appdirect.repository.UserAccountRepository;
import com.appdirect.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService{
	
	@Autowired
	UserAccountRepository userAccountRepository;
	@Override
	public UserAccount saveAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountRepository.save(userAccount);
	}

}
