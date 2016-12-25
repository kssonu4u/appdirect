package com.appdirect.service;

import com.appdirect.dto.ApiResponse;
import com.appdirect.dto.EventInfo;

/**
 * @author saurav interface for handling different type of events
 *
 */
public interface EventService {
	ApiResponse processEvent(EventInfo eventInfo);
}
