package com.socialnet.login.service.remote;

import org.springframework.stereotype.Component;

import com.socialnet.login.model.TemplateResponse;
import com.socialnet.login.model.UsuariosDto;

@Component
public class UsuariosServiceClientFallback implements UsuariosServiceRemote {

	@Override
	public TemplateResponse existeUsuario(String mail) {
		// TODO Auto-generated method stub
		return new TemplateResponse("Servicio No Disponible", "400", mail);
	}

	@Override
	public UsuariosDto validaUsuario(String id) {
		// TODO Auto-generated method stub
		return new UsuariosDto();
	}

}
