package com.socialnet.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialnet.posts.entity.Comentarios;
import com.socialnet.posts.model.ComentariosDto;
import com.socialnet.posts.model.TemplateResponse;
import com.socialnet.posts.repository.ComentariosRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {
	
	@Autowired
	private ComentariosRepository comentariosRepository;

	@Override
	public TemplateResponse guardarComentario(ComentariosDto dto) {
		Comentarios comentario = Comentarios.from(dto);
		comentario = comentariosRepository.saveAndFlush(comentario);
		return new TemplateResponse("Se guardo Comentario", "201", comentario);
	}

	@Override
	public List<Comentarios> buscaPorIdPost(String idPost) {
		// TODO Auto-generated method stub
		return comentariosRepository.findByIdPost(idPost);
	}

	@Override
	public List<Comentarios> buscaPorIdUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		return comentariosRepository.findByIdUsuario(idUsuario);
	}

}
