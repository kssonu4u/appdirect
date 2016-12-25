package com.appdirect.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.entity.Subscription;
import com.appdirect.entity.User;
import com.appdirect.service.EventService;
import com.appdirect.service.SubscriptionService;

/**
 * @author saurav service for handling User assignment request in a particular
 *         subscription
 *
 */
@Service("UserAssignment")
public class UserAssignmentServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(UserAssignmentServiceImpl.class);

	@Autowired
	private SubscriptionService subscriptionService;

	@Override
	public ApiResponse processEvent(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		if (null != eventInfo && null != eventInfo.getPayload() && null != eventInfo.getPayload().getUser()
				&& null != eventInfo.getPayload().getAccount().getAccountIdentifier()) {
			Subscription existingSubscription = subscriptionService
					.getSubscriptionByUserId(eventInfo.getPayload().getUser().getUuid());
			if (null != existingSubscription) {
				return new ApiResponse(false, "User all ready present in the existing subscription");
			}
			logger.info("Processing user assignment  event for account :" + eventInfo.getPayload().getUser().getUuid());
			Subscription subscriptions = subscriptionService
					.getSubscriptionById(eventInfo.getPayload().getAccount().getAccountIdentifier());
			List<User> users = subscriptions.getUsers();
			User user = new User();
			user.setEmail(eventInfo.getPayload().getUser().getEmail());
			user.setFirstName(eventInfo.getPayload().getUser().getFirstName());
			user.setLastName(eventInfo.getPayload().getUser().getLastName());
			user.setLanguage(eventInfo.getPayload().getUser().getLanguage());
			user.setOpenId(eventInfo.getPayload().getUser().getOpenId());
			user.setUuid(eventInfo.getPayload().getUser().getUuid());
			users.add(user);
			subscriptions.setUsers(users);
			subscriptionService.saveSubscription(subscriptions);
			return new ApiResponse(true, "User assigned successfullly to Subscription account :->", null,
					eventInfo.getPayload().getUser().getUuid());
		}
		return new ApiResponse(false,
				"Event Info is null or one of the attribute of Event Info is null in UserAssignment Event");
	}

}
