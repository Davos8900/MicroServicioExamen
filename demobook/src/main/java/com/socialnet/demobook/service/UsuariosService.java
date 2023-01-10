package com.socialnet.demobook.service;

import java.util.List;

import com.socialnet.demobook.entity.Usuarios;
import com.socialnet.demobook.model.UsuariosDto;

public interface UsuariosService {
	
	Usuarios obtenerById(String id);
	
	Usuarios guardar(UsuariosDto usuariosDto);
	
	Usuarios modificar(String id, UsuariosDto usuariosDto);
	
	List<Usuarios> listaUsuarios();
	
	Usuarios usuarioByMail(String mail);
	
	Usuarios usuariosByTag(String tag);

}
