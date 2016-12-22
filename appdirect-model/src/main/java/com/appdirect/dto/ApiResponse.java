package com.appdirect.dto;

import com.appdirect.appdirectdto.type.ErrorCode;

public class ApiResponse {
	
	private String accountIdentifier;

	private String userIdentifier;

	private ErrorCode errorCode;

	private String message;

	private boolean success;

	public ApiResponse() {
	}

	public ApiResponse(boolean success, String message) {
		this.message = message;
		this.success = success;
	}

	public ApiResponse(boolean success, String message, ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.success = success;
	}

	public ApiResponse(boolean success, String message, ErrorCode errorCode, String accountIdentifier) {
		super();
		this.accountIdentifier = accountIdentifier;
		this.errorCode = errorCode;
		this.message = message;
		this.success = success;
	}

	public ApiResponse(boolean success, String message, ErrorCode errorCode, String accountIdentifier, String userIdentifier) {
		super();
		this.accountIdentifier = accountIdentifier;
		this.userIdentifier = userIdentifier;
		this.errorCode = errorCode;
		this.message = message;
		this.success = success;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}


}
