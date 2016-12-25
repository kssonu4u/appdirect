package com.appdirect.service;

import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;

/**
 * @author saurav interface with all the functions related to events
 *
 */
public interface EventEngineService {

	EventInfo getEventInformation(String eventUrl);

	ApiResponse saveEventInformation(EventInfo eventInfo);
}
