package com.appdirect.exception;

/**
 * @author saurav This exception is for handling runtime exception occured
 *         during fething information from appdirect via event url
 */
public class EventFetchException extends RuntimeException {

	private static final long serialVersionUID = 6379904927675167879L;

	public EventFetchException(String exceptionReason) {
		super(exceptionReason);
	}
}
