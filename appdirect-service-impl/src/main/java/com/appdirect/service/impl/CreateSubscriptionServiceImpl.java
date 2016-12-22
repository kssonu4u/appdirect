package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.entity.UserAccount;
import com.appdirect.service.EventService;
import com.appdirect.service.UserAccountService;

@Service("CreateSubscription")
public class CreateSubscriptionServiceImpl implements EventService{
	
	@Autowired
	private UserAccountService userAccountService;
	@Override
	public ApiResponse processEvent(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		UserAccount userAccount = new UserAccount();
        userAccount.setAccountIdentifier("AAAA");
		UserAccount savedAccount = userAccountService.saveAccount(userAccount);
		return new ApiResponse(true, "Account created successfully", null, savedAccount.getId());
	}

}
