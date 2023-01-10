package com.socialnet.login.service;

public class LoginNoAuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String id;
	
	public LoginNoAuthException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static LoginNoAuthException from(String message, String id) {
		return new LoginNoAuthException(message, id);
	}
	
	public String getId() {
		return id;
	}
}
