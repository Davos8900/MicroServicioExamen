package com.socialnet.login.service;

public class LoginNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String id;
	
	public LoginNotFoundException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static LoginNotFoundException from(String message, String id) {
		return new LoginNotFoundException(message, id);
	}
	
	public String getId() {
		return id;
	}
}
