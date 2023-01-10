package com.socialnet.amigos.service.remote;

import org.springframework.stereotype.Component;

import com.socialnet.amigos.model.TemplateResponse;
import com.socialnet.amigos.model.remote.UsuariosDto;

@Component
public class UsuariosServiceClientFallback implements UsuariosServiceRemote {

	@Override
	public TemplateResponse existeUsuario(String tag) {
		// TODO Auto-generated method stub
		return new TemplateResponse("Servicio No Disponible", "400", tag);
	}

	@Override
	public UsuariosDto obtenerUsuarios(String id) {
		// TODO Auto-generated method stub
		return new UsuariosDto();
	}

}
