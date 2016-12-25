package com.appdirect.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.appdirect.appdirectdto.type.PriceDuration;
import com.appdirect.appdirectdto.type.PriceUnit;
import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.dto.EventUserAddress;
import com.appdirect.dto.EventUserInfo;
import com.appdirect.dto.Marketplace;
import com.appdirect.dto.Order;
import com.appdirect.dto.OrderItem;
import com.appdirect.dto.Organization;
import com.appdirect.dto.PayloadInfo;
import com.appdirect.service.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateSubscriptionServiceImplTest {

	@Autowired
	@Qualifier("CreateSubscription")
	private EventService createSubscriptionService;

	@Test
	public void testNullCase() {
		ApiResponse apiresponse = createSubscriptionService.processEvent(null);
		Assert.assertEquals(false, apiresponse.getSuccess());
	}

	@Test
	public void testCreateSubscription() {
		EventInfo eventInfo = new EventInfo();
		PayloadInfo payloadInfo = new PayloadInfo();
		Organization organization = new Organization("Test Country", "Test Name", "Test Uuid", "Test Website",
				"Test Phone Number");
		Marketplace marketplace = new Marketplace("Test base url", "Test Partner");
		EventUserAddress eventUserAddress = new EventUserAddress("Test", "Test", "Test", "Test", "Test", "Test", "Test",
				"Test", "Test");
		EventUserInfo eventUserInfo = new EventUserInfo(eventUserAddress, "Test", "Test", "Test", "Test", "Test",
				"Test");
		OrderItem orderItem1 = new OrderItem(2, PriceUnit.GIGABYTE);
		OrderItem orderItem2 = new OrderItem(4, PriceUnit.MEGABYTE);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		Order order = new Order("Test", PriceDuration.ONE_TIME, orderItems);
		payloadInfo.setCompany(organization);
		payloadInfo.setOrder(order);
		eventInfo.setMarketplace(marketplace);
		eventInfo.setCreator(eventUserInfo);
		eventInfo.setPayload(payloadInfo);
		ApiResponse apiresponse = createSubscriptionService.processEvent(eventInfo);
		Assert.assertEquals(true, apiresponse.getSuccess());
	}

}
