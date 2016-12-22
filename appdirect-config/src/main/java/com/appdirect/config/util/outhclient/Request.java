package com.appdirect.config.util.outhclient;

public class Request {

	private String contentType;
	private String accept;

	public Request(String contentType, String accept) {
		super();
		this.contentType = contentType;
		this.accept = accept;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

}
