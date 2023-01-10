package com.socialnet.login.service;

import com.socialnet.login.model.LoginInfoDto;
import com.socialnet.login.model.RespuestaDto;
import com.socialnet.login.model.TemplateResponse;
import com.socialnet.login.model.UsuariosDto;

public interface LoginService {
	RespuestaDto pruebaRemoteService(String id);
	TemplateResponse existeUsuario(String mail);
	TemplateResponse loginOk(LoginInfoDto info);
	UsuariosDto usuarioLogueado();
}
