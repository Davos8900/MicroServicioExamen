package com.socialnet.posts.model;

public class ComentariosDto {
	private String idPost;
	private String idUsuario;
	private String mensaje;
	private String fechaPost;
	
	public ComentariosDto() {
		
	}

	public ComentariosDto(String idPost, String idUsuario, String mensaje, String fechaPost) {
		super();
		this.idPost = idPost;
		this.idUsuario = idUsuario;
		this.mensaje = mensaje;
		this.fechaPost = fechaPost;
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
