package com.socialnet.posts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.socialnet.posts.model.PostsDto;

@Entity
@Table(name = "posts")
public class Posts implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String propietario;
	@Column(name = "propietario_tag")
	private String propietarioTag;
	private String titulo;
	private String mensaje;
	private String adjunto;
	@Column(name = "fecha_post")
	private String fechaPost;
	
	
	public static Posts from(PostsDto postsDto) {
		Posts posts = new Posts();
		posts.setId(postsDto.getId());
		posts.setPropietario(postsDto.getPropietario());
		posts.setPropietarioTag(postsDto.getPropietarioTag());
		posts.setTitulo(postsDto.getTitulo());
		posts.setMensaje(postsDto.getMensaje());
		posts.setAdjunto(postsDto.getAdjunto());
		posts.setFechaPost(postsDto.getFechaPost());
		return posts;
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
