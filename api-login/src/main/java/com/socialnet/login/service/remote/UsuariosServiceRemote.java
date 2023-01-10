package com.socialnet.login.service.remote;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialnet.login.model.TemplateResponse;
import com.socialnet.login.model.UsuariosDto;

@FeignClient(name= "api-usuarios", fallback = UsuariosServiceClientFallback.class, configuration = ClientRemoteConfig.class)
public interface UsuariosServiceRemote {
	@RequestMapping(method = GET, value = "usuarios/v1/{id}", produces = "application/json")
	UsuariosDto validaUsuario(@PathVariable("id")String id);
	
	@RequestMapping(method = GET, value = "usuarios/v1/mail/{mail}", produces = "application/json")
	TemplateResponse existeUsuario(@PathVariable("mail") String mail);
}
