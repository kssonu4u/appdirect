package com.appdirect.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.appdirect.appdirectdto.type.ErrorCode;
import com.appdirect.config.util.outhclient.OauthClient;
import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.exception.EventFetchException;
import com.appdirect.exception.EventProcessException;
import com.appdirect.service.EventEngineService;
import com.appdirect.service.EventService;
import com.google.gson.Gson;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@Service
public class EventEngineServiceImpl implements EventEngineService {

	@Autowired
	private OauthClient oauthClient;

	@Autowired
	@Qualifier("CreateSubscription")
	private EventService createSubscriptionService;

	@Autowired
	@Qualifier("CancelSubscription")
	private EventService cancelSubscriptionService;

	@Autowired
	@Qualifier("ChangeSubscription")
	private EventService changeSubscriptionService;

	@Autowired
	@Qualifier("UserAssignment")
	private EventService userAssignmentService;

	@Autowired
	@Qualifier("UserunAssignment")
	private EventService userUnAssignment;

	private static final Logger logger = LoggerFactory.getLogger(EventEngineServiceImpl.class);

	@Override
	public EventInfo getEventInformation(String eventUrl) {
		// TODO Auto-generated method stub
		String responsFromAppDirect = null;
		Gson gson = new Gson();
		try {
			// send a signed oauth request to get json payload from appdirect
			// server
			responsFromAppDirect = oauthClient.getEventInfo(eventUrl);
			logger.debug("Response From AppDirect with eventURL:->" + eventUrl + " JSON:->" + responsFromAppDirect);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException e) {
			logger.debug("Exception occured while fetching response from AppDirect  with event URL:->" + eventUrl
					+ " Exception Details :->" + e.getMessage());
			throw new EventFetchException("Exception occured while fetching response from AppDirect  with event URL: : "
					+ eventUrl + " Exception Details :->" + e.getMessage());
		}
		logger.info("Response from Appdirect is :->" + responsFromAppDirect);
		return gson.fromJson(responsFromAppDirect, EventInfo.class);
	}

	@Override
	public ApiResponse saveEventInformation(EventInfo eventInfo) {
		// TODO Auto-generated method stub
		try {
			switch (eventInfo.getType()) {
			case SUBSCRIPTION_ORDER:
				return createSubscriptionService.processEvent(eventInfo);
			case USER_ASSIGNMENT:
				return userAssignmentService.processEvent(eventInfo);
			case USER_UNASSIGNMENT:
				return userUnAssignment.processEvent(eventInfo);
			case SUBSCRIPTION_CHANGE:
				return changeSubscriptionService.processEvent(eventInfo);
			case SUBSCRIPTION_CANCEL:
				return cancelSubscriptionService.processEvent(eventInfo);
			default:
				return new ApiResponse(false,
						"Event type not supported by this endpoint:->" + String.valueOf(eventInfo.getType()),
						ErrorCode.UNKNOWN_ERROR);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new EventProcessException("Exception occured while processing event of type :-> "
					+ eventInfo.getType() + " Exception Details :->" + e.getMessage());
		}
	}

}
