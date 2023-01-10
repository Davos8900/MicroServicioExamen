package com.socialnet.demobook.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnet.demobook.service.UsuariosNotFoundException;

@RestControllerAdvice
public class ApiManejadorExcepcion {
	@Autowired
	private ObjectMapper mapper;
	
	@ExceptionHandler(UsuariosNotFoundException.class)
	public HttpEntity<?> notFound(UsuariosNotFoundException exception) {
		
		HashMap<String, String> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("mensaje", exception.getMessage());
		body.put("detalle", exception.getDetalle());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

}
