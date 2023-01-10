package com.socialnet.posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialnet.posts.entity.Posts;
import com.socialnet.posts.model.PostsDto;
import com.socialnet.posts.model.TemplateResponse;
import com.socialnet.posts.repository.PostsRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostsRepository postsRepository;
	@Override
	public TemplateResponse guardarPost(PostsDto dto) {
		Posts posts = Posts.from(dto);
		posts = postsRepository.saveAndFlush(posts);
		return new TemplateResponse("Se publico Post!!", "200", posts);
	}
	
	@Override
	public Posts obtenerPost(String id){
		return postsRepository.findById(id).orElseThrow(() -> PostNotFoundException.from("No se encontro Post", id));
	}
}
