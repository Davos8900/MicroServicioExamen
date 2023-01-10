package com.socialnet.posts.service;

public class PostNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String id;
	
	public PostNotFoundException(String message, String id) {
		super(message);
		this.id = id;
	}
	
	public static PostNotFoundException from(String message, String id ) {
		return new PostNotFoundException(message, id);
	}

	public String getId() {
		return id;
	}
	
}
