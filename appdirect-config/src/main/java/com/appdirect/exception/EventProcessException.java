package com.appdirect.exception;

public class EventProcessException extends RuntimeException {

	/**
	 * This exception is for handling runtime exception occured during processsing 
	 * event for a particular type
	 */
	private static final long serialVersionUID = 6379904927675167879L;
	
	public EventProcessException(String exceptionReason){
		super(exceptionReason);
	}
}
