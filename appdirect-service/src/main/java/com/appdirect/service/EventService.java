package com.appdirect.service;

import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;

public interface EventService {
	ApiResponse processEvent(EventInfo eventInfo);
}
