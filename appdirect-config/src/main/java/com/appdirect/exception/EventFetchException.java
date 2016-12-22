package com.appdirect.exception;

public class EventFetchException extends RuntimeException {

	/**
	 * This exception is for handling runtime exception occured during fething
	 * information from appdirect via event url
	 */
	private static final long serialVersionUID = 6379904927675167879L;
	
	public EventFetchException(String exceptionReason){
		super(exceptionReason);
	}
}
