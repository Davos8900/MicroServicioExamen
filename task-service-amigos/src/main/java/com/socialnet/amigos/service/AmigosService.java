package com.socialnet.amigos.service;

import java.util.List;

import com.socialnet.amigos.entity.Amigos;

public interface AmigosService {
	List<Amigos> obtenAmigos(String idUsuario);
}
