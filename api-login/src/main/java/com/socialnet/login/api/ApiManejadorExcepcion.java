package com.socialnet.login.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnet.login.service.LoginNoAuthException;
import com.socialnet.login.service.LoginNotFoundException;

@RestControllerAdvice
public class ApiManejadorExcepcion {
	@Autowired
	private ObjectMapper objectMapper;

	@ExceptionHandler(LoginNotFoundException.class)
	public HttpEntity notFound(LoginNotFoundException exception) {

		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	
	@ExceptionHandler(LoginNoAuthException.class)
	public HttpEntity unauthorized(LoginNoAuthException exception) {
		
		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
	}
}
