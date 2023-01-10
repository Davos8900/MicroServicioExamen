package com.socialnet.amigos.model.remote.async;

public class PostsDto {
	private String id;
	private String propietario;
	private String propietarioTag;
	private String titulo;
	private String mensaje;
	private String adjunto;
	private String fechaPost;
	
	public PostsDto() {
		
	}

	public PostsDto(String id, String propietario, String propietarioTag, String titulo, String mensaje, String adjunto,
			String fechaPost) {
		super();
		this.id = id;
		this.propietario = propietario;
		this.propietarioTag = propietarioTag;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.adjunto = adjunto;
		this.fechaPost = fechaPost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getPropietarioTag() {
		return propietarioTag;
	}

	public void setPropietarioTag(String propietarioTag) {
		this.propietarioTag = propietarioTag;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}

	public String getFechaPost() {
		return fechaPost;
	}

	public void setFechaPost(String fechaPost) {
		this.fechaPost = fechaPost;
	}
	
}
