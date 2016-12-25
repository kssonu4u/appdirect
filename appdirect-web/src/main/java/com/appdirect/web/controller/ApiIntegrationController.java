package com.appdirect.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.appdirectdto.type.ErrorCode;
import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;
import com.appdirect.exception.EventFetchException;
import com.appdirect.service.EventEngineService;

/**
 * @author saurav end point for handling requests from appdirect
 *
 */
@RestController
@RequestMapping("/api/appdirectintegration/v1")
public class ApiIntegrationController {

	private static final Logger logger = LoggerFactory.getLogger(ApiIntegrationController.class);

	@Autowired
	private EventEngineService eventInformationService;

	@RequestMapping(value = "/eventlistner", method = RequestMethod.GET)
	public ApiResponse handleEvent(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "eventUrl", required = false) String eventUrl,
			@RequestParam(value = "token", required = false) String token) {
		if (null != eventUrl && !eventUrl.isEmpty()) {
			logger.info("Event Url received is :- " + eventUrl);
			try {
				EventInfo eventInfo = eventInformationService.getEventInformation(eventUrl);
				return eventInformationService.saveEventInformation(eventInfo);
			} catch (EventFetchException e) {
				// TODO: handle exception
				return new ApiResponse(false, e.getMessage());
			}
		}
		return new ApiResponse(false, "Event url is empty", ErrorCode.MISSING_EVENT_URL);

	}

}
