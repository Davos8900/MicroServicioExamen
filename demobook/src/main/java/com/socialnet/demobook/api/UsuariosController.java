package com.socialnet.demobook.api;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.socialnet.demobook.entity.Usuarios;
import com.socialnet.demobook.model.TemplateResponse;
import com.socialnet.demobook.model.UsuariosDto;
import com.socialnet.demobook.service.UsuariosServiceImpl;

@RestController
@RequestMapping("usuarios/v1")
public class UsuariosController {
	
	private static final Logger LOGGER = Logger.getLogger(UsuariosController.class);
	@Autowired
	private UsuariosServiceImpl impl;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public TemplateResponse crear(@RequestBody UsuariosDto dto) {
		LOGGER.info(">>>> Creando Usuario");
		
		Usuarios usuarios = impl.guardar(dto);
		
		TemplateResponse response = new TemplateResponse("Creacion de usuario", "201", usuarios);
		
		return response;
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Usuarios consultaUsuario(@PathVariable("id") String id) {
		LOGGER.info(">>>> Consultando usuario");
		
		return impl.obtenerById(id);
	}
	
	@GetMapping
	@ResponseStatus(OK)
	public List<Usuarios> listaUsuarios() {
		LOGGER.info(">>>  Listando Usuarios");
		
		return impl.listaUsuarios();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse modificaUsuario(@PathVariable("id") String id, @RequestBody UsuariosDto usuariosDto) {
		LOGGER.info(">>> Modificando usuario");
		
		Usuarios usuarios = impl.modificar(id, usuariosDto);
		TemplateResponse response = new TemplateResponse("Usuario Actualizado", "200", usuarios);
		
		return response;
	}
	
	@GetMapping("/mail/{mail}")
	@ResponseStatus(OK)
	public TemplateResponse buscaUsuarioPorMail(@PathVariable("mail") String mail) {
		LOGGER.info(">>> Buscando usuario");
		
		Usuarios usuarios = impl.usuarioByMail(mail);
		TemplateResponse respuesta = new TemplateResponse("Usuario Encontrado", "200", usuarios);
		return respuesta;
	}
	
	@GetMapping("/tag/{tag}")
	@ResponseStatus(OK)
	public TemplateResponse buscaUsuarioPorTag(@PathVariable("tag") String tag) {
		LOGGER.info(">>> Buscando por Tag");
		
		Usuarios usuarios = impl.usuariosByTag(tag);
		TemplateResponse respuesta = new TemplateResponse("Usuario Encontrado", "200", usuarios);
		return respuesta;
	}
}
