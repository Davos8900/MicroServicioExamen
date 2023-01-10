package com.socialnet.login.service.remote;

public class ClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final int errorStatus;
	private final String payload;
	
	public ClientException(String message, int errorStatus, String payload) {
		super(message);
		this.errorStatus = errorStatus;
		this.payload = payload;
		// TODO Auto-generated constructor stub
	}

	public int getErrorStatus() {
		return errorStatus;
	}

	public String getPayload() {
		return payload;
	}
	
	
}
