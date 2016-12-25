package com.appdirect.service.impl;

import java.util.Iterator;
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
 * @author saurav service for handling user unassignment request in a particular
 *         subscription
 *
 */
@Service("UserunAssignment")
public class UserUnAssignmentServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(UserUnAssignmentServiceImpl.class);

	@Autowired
	private SubscriptionService subscriptionService;

	@Override
	public ApiResponse processEvent(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		if (null != eventInfo && null != eventInfo.getPayload() && null != eventInfo.getPayload().getUser()
				&& null != eventInfo.getPayload().getAccount().getAccountIdentifier()) {
			Subscription existingSubscription = subscriptionService
					.getSubscriptionByUserId(eventInfo.getPayload().getUser().getUuid());
			if (null == existingSubscription) {
				return new ApiResponse(false, "User not  present in the existing subscription");
			}
			logger.info("Processing user unassignment  event for user with uuid :->"
					+ eventInfo.getPayload().getUser().getUuid());
			Subscription subscriptions = subscriptionService
					.getSubscriptionById(eventInfo.getPayload().getAccount().getAccountIdentifier());
			List<User> users = subscriptions.getUsers();
			Iterator<User> iterator = users.iterator();
			while (iterator.hasNext()) {
				User u = iterator.next();
				if (eventInfo.getPayload().getUser().getUuid().equals(u.getUuid())) {
					iterator.remove();
					break;
				}
			}
			subscriptions.setUsers(users);
			subscriptionService.saveSubscription(subscriptions);
			return new ApiResponse(true, "User unassigned successfully from Subscription account ", null);
		}
		return new ApiResponse(false,
				"Event Info is null or one of the attribute of Event Info is null in User Unassignment Event");
	}

}
