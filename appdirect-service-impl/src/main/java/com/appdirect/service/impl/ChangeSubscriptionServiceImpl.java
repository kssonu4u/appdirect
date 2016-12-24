package com.appdirect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.appdirectdto.type.ErrorCode;
import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.dto.OrderItem;
import com.appdirect.entity.Item;
import com.appdirect.entity.OrderDetails;
import com.appdirect.entity.Subscriptions;
import com.appdirect.service.EventService;
import com.appdirect.service.SubscriptionService;

@Service("ChangeSubscription")
public class ChangeSubscriptionServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(ChangeSubscriptionServiceImpl.class);

	@Autowired
	private SubscriptionService subscriptionService;

	@Override
	public ApiResponse processEvent(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		if (null != eventInfo && null != eventInfo.getPayload() && null != eventInfo.getPayload().getOrder()
				&& null != eventInfo.getPayload().getOrder().getEditionCode()
				&& null != eventInfo.getPayload().getOrder().getPricingDuration()) {
			String accountId = eventInfo.getPayload().getAccount().getAccountIdentifier();
			logger.info("Processing subscription change event for account :" + accountId);
			Subscriptions subscriptions = subscriptionService.getSubscriptionById(accountId);
			if (null == subscriptions) {
				return new ApiResponse(false,
						"Subscription account doesnot exists for account identifier:->" + accountId,
						ErrorCode.ACCOUNT_NOT_FOUND);
			}
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
			subscriptions.setOrderDetails(orderDetail);
			Subscriptions savedSubscription = subscriptionService.saveSubscription(subscriptions);
			return new ApiResponse(true, "Subscription Changed  successfully for account :" + savedSubscription.getId(),
					null, savedSubscription.getId());

		}
		return new ApiResponse(false, "Event Info is null or one of the attribute of Event Info is null");
	}

}
