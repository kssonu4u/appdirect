package com.appdirect.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.appdirectdto.type.ErrorCode;
import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.entity.Subscriptions;
import com.appdirect.service.EventService;
import com.appdirect.service.SubscriptionService;

@Service("CancelSubscription")
public class CancelSubscriptionServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(CancelSubscriptionServiceImpl.class);

	@Autowired
	private SubscriptionService subscriptionService;

	@Override
	public ApiResponse processEvent(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		if (null != eventInfo && null != eventInfo.getPayload() && null != eventInfo.getPayload().getAccount()
				&& null != eventInfo.getPayload().getAccount().getAccountIdentifier()) {
			String accountId = eventInfo.getPayload().getAccount().getAccountIdentifier();
			logger.info("Processing subscription cancel event for account :" + accountId);
			Subscriptions subscriptions = subscriptionService.getSubscriptionById(accountId);
			if (null == subscriptions) {
				return new ApiResponse(false,
						"Subscription account doesnot exists for account identifier:->" + accountId,
						ErrorCode.ACCOUNT_NOT_FOUND);
			}
			subscriptionService.deleteSubscription(subscriptions);
			return new ApiResponse(true, "Subscription cancelled successfully for account :" + accountId, null,
					accountId);

		}
		return new ApiResponse(false, "Event Info is null or one of the attribute of Event Info is null");
	}

}
