package com.socialnet.amigos.service.remote;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialnet.amigos.model.TemplateResponse;
import com.socialnet.amigos.model.remote.UsuariosDto;

@FeignClient(name= "api-usuarios", fallback = UsuariosServiceClientFallback.class, configuration = ClientRemoteConfig.class)
public interface UsuariosServiceRemote {
	@RequestMapping(method = GET, value = "usuarios/v1/tag/{tag}", produces = "application/json")
	TemplateResponse existeUsuario(@PathVariable("tag") String tag);
	@RequestMapping(method = GET, value = "usuarios/v1/{id}", produces = "application/json")
	UsuariosDto obtenerUsuarios(@PathVariable("id") String id);
}
