package com.socialnet.posts.service.remote.async;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.socialnet.posts.RabbitConfigConsumer;
import com.socialnet.posts.model.PostsDto;

@Component
public class PublicaPost {
	
	public static final Logger LOG = Logger.getLogger(PublicaPost.class);
	private Gson json = new Gson();
	
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_POSTS_ENVIO)
	public void escucharPosts(Message message) {
		String body = new String(message.getBody());
		//Transformar mensaje a Dto de Post
		PostsDto postsDto = json.fromJson(body, PostsDto.class);
		
		//Impactar mensaje en BD
		LOG.info(postsDto);
	}
}
