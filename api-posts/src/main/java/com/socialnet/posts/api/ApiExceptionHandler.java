package com.socialnet.posts.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnet.posts.service.PostNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {
	@Autowired
	private ObjectMapper mapper;
	
	@ExceptionHandler(PostNotFoundException.class)
	public HttpEntity notfound(PostNotFoundException exception) {
		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
}
