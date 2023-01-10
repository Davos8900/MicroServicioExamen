package com.socialnet.demobook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socialnet.demobook.entity.Usuarios;
import com.socialnet.demobook.model.UsuariosDto;
import com.socialnet.demobook.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	private UsuariosRepository usuariosRepository;
	
	public UsuariosServiceImpl(UsuariosRepository repository) {
		this.usuariosRepository = repository;
	}
	
	@Override
	public Usuarios obtenerById(String id) {
		return usuariosRepository.findById(id)
				.orElseThrow(() -> UsuariosNotFoundException.from("Sin resultados", id, ""));
	}

	@Override
	public Usuarios guardar(UsuariosDto usuariosDto) {
		Usuarios usuarios = Usuarios.from(usuariosDto);
		return usuariosRepository.save(usuarios);
	}

	@Override
	public Usuarios modificar(String id, UsuariosDto usuariosDto) {
		Usuarios usuarios = usuariosRepository.findById(id)
				.orElseThrow(() -> UsuariosNotFoundException.from("No se encontro usuario", id, ""));
		
		usuarios = usuarios.from(usuariosDto);
		
		usuarios = usuariosRepository.save(usuarios);
		
		return usuarios;
	}

	@Override
	public List<Usuarios> listaUsuarios() {
		return usuariosRepository.findAll();
	}
	
	@Override
	public Usuarios usuarioByMail(String mail) {
		return usuariosRepository.findByMail(mail)
				.orElseThrow(() -> UsuariosNotFoundException.from("Sin resultado","-1", mail));
	}

	@Override
	public Usuarios usuariosByTag(String tag) {
		// TODO Auto-generated method stub
		return usuariosRepository.findByTag(tag)
				.orElseThrow(() -> UsuariosNotFoundException.from("Sin resultados","-1", tag));
	}
	
	
}
