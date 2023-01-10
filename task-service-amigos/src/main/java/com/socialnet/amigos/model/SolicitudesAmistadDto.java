package com.socialnet.amigos.model;

public class SolicitudesAmistadDto {
	private String id;
	private String usuarioGenera;
	private String usuarioRecibe;
	private Boolean aceptada;
	
	public SolicitudesAmistadDto() {
		
	}
	
	public SolicitudesAmistadDto(String id, String usuarioGenera, String usuarioRecibe, Boolean aceptada) {
		super();
		this.id = id;
		this.usuarioGenera = usuarioGenera;
		this.usuarioRecibe = usuarioRecibe;
		this.aceptada = aceptada;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuarioGenera() {
		return usuarioGenera;
	}
	public void setUsuarioGenera(String usuarioGenera) {
		this.usuarioGenera = usuarioGenera;
	}
	public String getUsuarioRecibe() {
		return usuarioRecibe;
	}
	public void setUsuarioRecibe(String usuarioRecibe) {
		this.usuarioRecibe = usuarioRecibe;
	}
	public Boolean getAceptada() {
		return aceptada;
	}
	public void setAceptada(Boolean aceptada) {
		this.aceptada = aceptada;
	}
	
}
