package com.socialnet.amigos.model;

public class AmigosDto {
	private String idUsuario;
	private String idAmigo;
	private String fechaAmistad;
	private String parentesco;
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdAmigo() {
		return idAmigo;
	}
	public void setIdAmigo(String idAmigo) {
		this.idAmigo = idAmigo;
	}
	public String getFechaAmistad() {
		return fechaAmistad;
	}
	public void setFechaAmistad(String fechaAmistad) {
		this.fechaAmistad = fechaAmistad;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
}
