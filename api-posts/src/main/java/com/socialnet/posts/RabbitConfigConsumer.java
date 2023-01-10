package com.socialnet.posts;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

public class RabbitConfigConsumer {
	public final static String QUEUE_POSTS_ENVIO = "queue-posts-envio";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_POSTS_ENVIO);
	}
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange-principal");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_POSTS_ENVIO);
	}
	
}
