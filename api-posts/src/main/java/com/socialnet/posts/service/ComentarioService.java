package com.socialnet.posts.service;

import java.util.List;

import com.socialnet.posts.entity.Comentarios;
import com.socialnet.posts.model.ComentariosDto;
import com.socialnet.posts.model.TemplateResponse;

public interface ComentarioService {
	TemplateResponse guardarComentario(ComentariosDto dto);
	List<Comentarios> buscaPorIdPost(String idPost);
	List<Comentarios> buscaPorIdUsuario(String idUsuario);
}
