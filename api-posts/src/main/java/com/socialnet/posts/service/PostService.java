package com.socialnet.posts.service;

import com.socialnet.posts.entity.Posts;
import com.socialnet.posts.model.PostsDto;
import com.socialnet.posts.model.TemplateResponse;

public interface PostService {
	TemplateResponse guardarPost(PostsDto dto);
	Posts obtenerPost(String id);
}
