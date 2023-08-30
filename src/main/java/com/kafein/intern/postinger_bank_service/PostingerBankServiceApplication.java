package com.kafein.intern.postinger_bank_service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;


@SpringBootApplication
@EnableRabbit
public class PostingerBankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostingerBankServiceApplication.class, args);
	}

	@Bean
	Queue withdrawalQueue() {
		return new Queue("withdrawalRequests");
	}
	@Bean
	Queue depositQueue() {
		return new Queue("depositRequests");
	}
	/*
	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(jackson2Converter());
		return factory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar listenerRegistrar) {
		listenerRegistrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}
	 */
}

