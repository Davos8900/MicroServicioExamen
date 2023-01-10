package com.socialnet.demobook.service;

public class UsuariosNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String id;
	private final String detalle;
	
	public UsuariosNotFoundException(String message, String id, String detalle) {
		super(message);
		this.id = id;
		this.detalle = detalle;
	}

	public static UsuariosNotFoundException from(String message, String id, String detalle) {
		return new UsuariosNotFoundException(message, id, detalle);
	}
	
	public String getId() {
		return id;
	}

	public String getDetalle() {
		return detalle;
	}
	
}
