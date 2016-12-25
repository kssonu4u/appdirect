package com.appdirect.dto;

import com.appdirect.appdirectdto.type.NoticeType;


/**
 * @author saurav class for representing notice info from appdirect 
 *
 */
public class EventNoticeInfo {

	private NoticeType type;

	private String message;

	public NoticeType getType() {
		return type;
	}

	public void setType(NoticeType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
