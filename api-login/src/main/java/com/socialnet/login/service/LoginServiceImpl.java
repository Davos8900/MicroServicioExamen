package com.socialnet.login.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnet.login.model.LoginInfoDto;
import com.socialnet.login.model.RespuestaDto;
import com.socialnet.login.model.TemplateResponse;
import com.socialnet.login.model.UsuariosDto;
import com.socialnet.login.service.remote.ClientException;
import com.socialnet.login.service.remote.UsuariosServiceRemote;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UsuariosServiceRemote remote;
	@Override
	public RespuestaDto pruebaRemoteService(String id) {
		try {
			UsuariosDto usuario = remote.validaUsuario(id);
			return new RespuestaDto(usuario.getTag(), 1);
		}catch (ClientException e) {
			// TODO: handle exception
			//return new RespuestaDto("No Existe Usuario", e.getErrorStatus());
			throw new LoginNotFoundException("No existe Usuario", "404");
		}
	}
	@Override
	public TemplateResponse existeUsuario(String mail) {
		try {
			TemplateResponse respuesta = remote.existeUsuario(mail);
			return respuesta;
		}catch (ClientException e) {
			// TODO: handle exception
			//return new RespuestaDto("No Existe Usuario", e.getErrorStatus());
			throw new LoginNotFoundException("No existe Usuario", "404");
		}
	}
	@Override
	public TemplateResponse loginOk(LoginInfoDto info) {
		try {
			TemplateResponse consulta = remote.existeUsuario(info.getUsermail());
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.convertValue(consulta.getDetalles(), Map.class);
			String word = map.get("magicWord").toString();
			if(info.getPassword().equals(word)) {
				return new TemplateResponse("Inicio de sesión valido", "200", info);
			}
			else {
				throw new LoginNoAuthException("Usuario o contraseña no valido", "401");
			}
		}catch (ClientException e) {
			// TODO: handle exception
			//return new RespuestaDto("No Existe Usuario", e.getErrorStatus());
			throw new LoginNotFoundException("No existe Usuario", "404");
		}
	}
	@Override
	public UsuariosDto usuarioLogueado() {
		// TODO Auto-generated method stub
		return null;
	}

}
