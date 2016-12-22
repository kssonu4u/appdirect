package com.appdirect.service;

import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;

public interface EventEngineService {

	EventInfo getEventInformation(String eventUrl);

	ApiResponse saveEventInformation(EventInfo eventInfo);
}
