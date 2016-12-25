package com.appdirect.exception;

/**
 * @author saurav This exception is for handling runtime exception occured
 *         during processing event in our system
 *
 */
public class EventProcessException extends RuntimeException {

	private static final long serialVersionUID = 6379904927675167879L;

	public EventProcessException(String exceptionReason) {
		super(exceptionReason);
	}
}
