package com.socialnet.posts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.socialnet.posts.model.ComentariosDto;

@Entity
@Table(name = "comentarios")
public class Comentarios implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_post")
	private String idPost;
	@Column(name = "id_usuario")
	private String idUsuario;
	private String mensaje;
	@Column(name = "fecha_post")
	private String fechaPost;
	
	public static Comentarios from(ComentariosDto comentariosDto) {
		Comentarios com = new Comentarios();
		com.setIdPost(comentariosDto.getIdPost());
		com.setIdUsuario(comentariosDto.getIdUsuario());
		com.setMensaje(comentariosDto.getMensaje());
		com.setFechaPost(comentariosDto.getFechaPost());
		return com;
	}
	
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getFechaPost() {
		return fechaPost;
	}
	public void setFechaPost(String fechaPost) {
		this.fechaPost = fechaPost;
	}
	
}
