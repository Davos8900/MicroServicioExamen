package com.socialnet.amigos.service;

public class SolicitudNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String id;
	
	public SolicitudNotFoundException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static SolicitudNotFoundException from(String message, String id) {
		return new SolicitudNotFoundException(message, id);
	}

	public String getId() {
		return id;
	}
	
}
