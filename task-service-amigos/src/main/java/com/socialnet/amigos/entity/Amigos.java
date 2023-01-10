package com.socialnet.amigos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.socialnet.amigos.model.AmigosDto;

@Entity
@Table(name = "amigos")
public class Amigos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_usuario")
	private String idUsuario;
	@Column(name = "id_amigo")
	private String idAmigo;
	@Column(name = "fecha_amistad")
	private String fechaAmistad;
	private String parentesco;
	
	public static Amigos from(AmigosDto amigosDto) {
		Amigos amigos = new Amigos();
		amigos.setIdUsuario(amigosDto.getIdUsuario());
		amigos.setIdAmigo(amigosDto.getIdAmigo());
		amigos.setFechaAmistad(amigosDto.getFechaAmistad());
		amigos.setParentesco(amigosDto.getParentesco());
		return amigos;
	}
	
	public AmigosDto to() {
		AmigosDto amigosDto = new AmigosDto();
		amigosDto.setIdUsuario(getIdUsuario());
		amigosDto.setIdAmigo(getIdAmigo());
		amigosDto.setFechaAmistad(getFechaAmistad());
		amigosDto.setParentesco(getParentesco());
		return amigosDto;
	}
	
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
