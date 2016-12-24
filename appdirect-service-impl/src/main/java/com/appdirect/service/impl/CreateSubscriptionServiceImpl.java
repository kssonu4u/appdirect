package com.appdirect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.appdirectdto.type.ErrorCode;
import com.appdirect.appdirectdto.type.SubscriptionStatus;
import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.dto.OrderItem;
import com.appdirect.entity.Company;
import com.appdirect.entity.OrderDetails;
import com.appdirect.entity.Item;
import com.appdirect.entity.Subscriptions;
import com.appdirect.entity.User;
import com.appdirect.service.EventService;
import com.appdirect.service.SubscriptionService;

@Service("CreateSubscription")
public class CreateSubscriptionServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(CreateSubscriptionServiceImpl.class);

	@Autowired
	private SubscriptionService subscriptionService;

	@Override
	public ApiResponse processEvent(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		if (null != eventInfo && null != eventInfo.getPayload() && null != eventInfo.getPayload().getCompany()
				&& null != eventInfo.getPayload().getCompany().getUuid()) {
			Subscriptions existingSubscription = subscriptionService
					.getSubscriptionById(eventInfo.getPayload().getCompany().getUuid());
			if (null != existingSubscription) {
				logger.debug("Subscription account exists with Id: " + existingSubscription.getId());
				return new ApiResponse(false,
						"Account already exists for account ID:-> " + eventInfo.getPayload().getCompany().getUuid(),
						ErrorCode.OPERATION_CANCELLED);
			}
			logger.info("Processing subscription create event for account :" + eventInfo.getPayload().getCompany().getUuid());
			Subscriptions subscription = new Subscriptions();
			subscription.setAccountIdentifier(eventInfo.getPayload().getCompany().getUuid());
			subscription.setNoticeType(null);
			subscription.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
			subscription.setBaseUrl(eventInfo.getMarketplace().getBaseUrl());
			subscription.setPartner(eventInfo.getMarketplace().getPartner());
			List<User> users = new ArrayList<>();
			User user = new User();
			user.setEmail(eventInfo.getCreator().getEmail());
			user.setFirstName(eventInfo.getCreator().getFirstName());
			user.setLastName(eventInfo.getCreator().getLastName());
			user.setLanguage(eventInfo.getCreator().getLanguage());
			user.setOpenId(eventInfo.getCreator().getOpenId());
			user.setUuid(eventInfo.getCreator().getUuid());
			users.add(user);
			subscription.setUsers(users);
			Company company = new Company();
			company.setCountry(eventInfo.getPayload().getCompany().getCountry() != null
					? eventInfo.getPayload().getCompany().getCountry() : "");
			company.setName(eventInfo.getPayload().getCompany().getName() != null
					? eventInfo.getPayload().getCompany().getName() : "");
			company.setPhoneNumber(eventInfo.getPayload().getCompany().getPhoneNumber() != null
					? eventInfo.getPayload().getCompany().getPhoneNumber() : "");
			company.setUuid(eventInfo.getPayload().getCompany().getUuid());
			company.setWebsite(eventInfo.getPayload().getCompany().getWebsite() != null
					? eventInfo.getPayload().getCompany().getWebsite() : "");
			subscription.setCompany(company);
			OrderDetails orderDetail = new OrderDetails();
			orderDetail.setEditionCode(eventInfo.getPayload().getOrder().getEditionCode());
			orderDetail.setPricingDuration(eventInfo.getPayload().getOrder().getPricingDuration().name());
			List<Item> items = new ArrayList<>();
			for (OrderItem item : eventInfo.getPayload().getOrder().getItems()) {
				Item orderItemTosave = new Item();
				orderItemTosave.setQuantity(item.getQuantity());
				orderItemTosave.setUnit(item.getUnit().name());
				items.add(orderItemTosave);
			}
			orderDetail.setItems(items);
			subscription.setOrderDetails(orderDetail);
			Subscriptions savedSubscription = subscriptionService.saveSubscription(subscription);
			return new ApiResponse(true, "Subscription account created successfully", null, savedSubscription.getId());
		}
		return new ApiResponse(false, "Event Info is null or one of the attribute of Event Info is null");
	}

}
