package com.socialnet.amigos.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.socialnet.amigos.entity.Amigos;
import com.socialnet.amigos.entity.SolicitudesAmistad;
import com.socialnet.amigos.model.BusquedaAmigoDto;
import com.socialnet.amigos.model.RespuestaSolicitudDto;
import com.socialnet.amigos.model.TemplateResponse;
import com.socialnet.amigos.service.AmigosServicesImpl;
import com.socialnet.amigos.service.SolicitudesAmistadServiceImpl;

@RestController
@RequestMapping("amigos/v1")
public class AmigosController {

	@Autowired
	private AmigosServicesImpl amigosServicesImpl;
	@Autowired
	private SolicitudesAmistadServiceImpl solicitudesServiceImpl;
	private Logger LOG = Logger.getLogger(AmigosController.class);
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public TemplateResponse obtenerAmigos(@PathVariable("id") String idUsuario) {
		List<Amigos> amigos = amigosServicesImpl.obtenAmigos(idUsuario);
		LOG.info(">>> Servicio obtenerAmigos");
		if(amigos == null || amigos.isEmpty()) {
			return new TemplateResponse("Lo siento, no tienes amigos!! :(", "200", amigos);
		} else {
			return new TemplateResponse("Amigos Encontrados", "200", amigos);
		}
	}
	
	@GetMapping("/solicitud/{id}")
	@ResponseStatus(OK)
	public SolicitudesAmistad buscarSolicitud(@PathVariable("id") String id) {
		LOG.info(">>> Servicio buscarSolicitud");
		return solicitudesServiceImpl.obtenerSolicitudById(id);
	}
	
	@GetMapping("/solicitudes/generadas/{idUsuario}")
	@ResponseStatus(OK)
	public TemplateResponse solicitudesGeneradas(@PathVariable("idUsuario") String idUsuario) {
		List<SolicitudesAmistad> solicitudes = solicitudesServiceImpl.obtenerSolicitudesGeneradas(idUsuario);
		LOG.info(">>> Servicio solicitudesGeneradas");
		return new TemplateResponse("Tus Solicitudes", "200", solicitudes);
	}
	
	@GetMapping("/solicitudes/bandeja/{idUsuario}")
	@ResponseStatus(OK)
	public TemplateResponse solicitudesRecibidas(@PathVariable("idUsuario") String idUsuario) {
		List<SolicitudesAmistad> solicitudes = solicitudesServiceImpl.obtenerSolicitudesRecibidas(idUsuario);
		LOG.info(">>> Servicio solicitudesRecibidas");
		return new TemplateResponse("Tu bandeja de solicitudes", "200", solicitudes);
	}
	
	@PostMapping("/solicitudes")
	@ResponseStatus(OK)
	public SolicitudesAmistad solicitudAmigo(@RequestBody BusquedaAmigoDto s) {
		LOG.info(">>> Servicio solicitudAmigo");
		return solicitudesServiceImpl.buscarSolicitud(s.getUsuarioGenera(), s.getUsuarioRecibe());
	}
	
	@PostMapping("/solicitud")
	@ResponseStatus(CREATED)
	public TemplateResponse responderSolicitud(@RequestBody RespuestaSolicitudDto respuesta) {
		LOG.info(">>> Servicio responderSolicitud");
		return solicitudesServiceImpl.procesarSolicitud(respuesta.getId(), respuesta.isAplicar());
	}
	
	@PostMapping("/solicitud/crear")
	@ResponseStatus(CREATED)
	public TemplateResponse crearSolicitud(@RequestBody BusquedaAmigoDto dto) {
		LOG.info(">>> Servicio crearSolicitud");
		return solicitudesServiceImpl.crearSolicitud(dto);
	}
}
