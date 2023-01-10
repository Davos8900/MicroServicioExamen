package com.socialnet.posts.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.socialnet.posts.entity.Comentarios;
import com.socialnet.posts.entity.Posts;
import com.socialnet.posts.model.ComentariosDto;
import com.socialnet.posts.model.PostsDto;
import com.socialnet.posts.model.TemplateResponse;
import com.socialnet.posts.service.ComentarioServiceImpl;
import com.socialnet.posts.service.PostServiceImpl;

@RestController
@RequestMapping("posts/v1")
public class PostsController {
	
	private static final Logger LOG = Logger.getLogger(PostsController.class);
	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private ComentarioServiceImpl comentarioServiceImpl;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crearPost(@RequestBody PostsDto dto) {
		LOG.info(">>> Creando Post");
		return postServiceImpl.guardarPost(dto);
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse buscarPost(@PathVariable("id") String id) {
		LOG.info(">>> Buscando Post");
		Posts posts = postServiceImpl.obtenerPost(id);
		return new TemplateResponse("Post Encontrado", "200", posts);
	}
	
	@PostMapping("/comentario")
	@ResponseStatus(CREATED)
	public TemplateResponse crearComentario(@RequestBody ComentariosDto comentariosDto) {
		LOG.info(">>> Creando Comentario");
		return comentarioServiceImpl.guardarComentario(comentariosDto);
		
	}
	
	@GetMapping("/comentario/{idPost}")
	@ResponseStatus(OK)
	public TemplateResponse buscarComentarioByPost(@PathVariable("idPost") String idPost) {
		List<Comentarios> lista = comentarioServiceImpl.buscaPorIdPost(idPost);
		return new TemplateResponse("Comentarios del Post", "200", lista);
	}
}
