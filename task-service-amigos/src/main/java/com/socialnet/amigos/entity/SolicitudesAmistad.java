package com.socialnet.amigos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.socialnet.amigos.model.SolicitudesAmistadDto;

@Entity
@Table
public class SolicitudesAmistad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@Column(name = "usuario_genera")
	private String usuarioGenera;
	@Column(name = "usuario_recibe")
	private String usuarioRecibe;
	private boolean aceptada;
	
	public static SolicitudesAmistad from(SolicitudesAmistadDto amistadDto) {
		SolicitudesAmistad amistad = new SolicitudesAmistad();
		amistad.setUsuarioGenera(amistadDto.getUsuarioGenera());
		amistad.setUsuarioRecibe(amistadDto.getUsuarioRecibe());
		amistad.setAceptada(amistadDto.getAceptada());
		return amistad;
	}
	
	public SolicitudesAmistadDto to() {
		return new SolicitudesAmistadDto(getId(), getUsuarioGenera(), getUsuarioRecibe(), Boolean.valueOf(isAceptada()));
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
	public boolean isAceptada() {
		return aceptada;
	}
	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}
	
}
