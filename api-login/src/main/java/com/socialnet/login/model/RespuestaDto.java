package com.socialnet.login.model;

public class RespuestaDto {
	private int status;
	private String mensaje;
	
	public RespuestaDto(String mensaje, int id) {
		super();
		this.status = id;
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getId() {
		return status;
	}
	public void setId(int id) {
		this.status = id;
	}
	
	
}
