package com.socialnet.demobook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.socialnet.demobook.model.UsuariosDto;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator= "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	private String tag;
	private String nombre;
	private Integer edad;
	@Column(name = "email")
	private String mail;
	@Column(name = "password")
	private String magicWord;
	
	public static Usuarios from(UsuariosDto usuariosDto) {
		Usuarios usuarios = new Usuarios();
		usuarios.setNombre(usuariosDto.getNombre());
		usuarios.setTag(usuariosDto.getTag());
		usuarios.setMail(usuariosDto.getMail());
		usuarios.setEdad(usuariosDto.getEdad());
		usuarios.setMagicWord(usuariosDto.getMagicWord());
		return usuarios;
	}
	
	public UsuariosDto to() {
		UsuariosDto usuarios = new UsuariosDto();
		usuarios.setId(getId());
		usuarios.setNombre(getNombre());
		usuarios.setEdad(getEdad());
		usuarios.setTag(getTag());
		usuarios.setMail(getMail());
		usuarios.setMagicWord(getMagicWord());
		return usuarios;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMagicWord() {
		return magicWord;
	}

	public void setMagicWord(String magicWord) {
		this.magicWord = magicWord;
	}

	
}
