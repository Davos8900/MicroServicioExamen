package com.socialnet.amigos.service;

import java.util.List;

import com.socialnet.amigos.entity.SolicitudesAmistad;
import com.socialnet.amigos.model.BusquedaAmigoDto;
import com.socialnet.amigos.model.TemplateResponse;

public interface SolicitudesAmistadService {
	SolicitudesAmistad obtenerSolicitudById(String id);
	List<SolicitudesAmistad> obtenerSolicitudesGeneradas(String idUsuario);
	List<SolicitudesAmistad> obtenerSolicitudesRecibidas(String idUsuario);
	SolicitudesAmistad buscarSolicitud(String usuarioGenera, String usuarioRecibe);
	TemplateResponse procesarSolicitud(String id, boolean aplicar);
	TemplateResponse crearSolicitud(BusquedaAmigoDto busquedaDto);
}
