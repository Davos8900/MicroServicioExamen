package com.socialnet.amigos.service.remote.async;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.socialnet.amigos.RabbitConfigConsumer;

@Component
public class EnvioPost {
	private static final Logger LOG = Logger.getLogger(EnvioPost.class);
	private RabbitTemplate rabbitTemplate;

	public EnvioPost(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendPost(String contrato) {
		LOG.info(">>> Se envía a Queue");
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_POSTS_ENVIO, contrato);
	}
}
