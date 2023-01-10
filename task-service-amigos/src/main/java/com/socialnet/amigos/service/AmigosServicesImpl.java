package com.socialnet.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialnet.amigos.entity.Amigos;
import com.socialnet.amigos.repository.AmigosRepository;

@Service
public class AmigosServicesImpl implements AmigosService {
	
	@Autowired
	private AmigosRepository amigosRepository;

	@Override
	public List<Amigos> obtenAmigos(String idUsuario) {
		// TODO Auto-generated method stub
		return amigosRepository.findByIdUsuario(idUsuario);
	}

}
