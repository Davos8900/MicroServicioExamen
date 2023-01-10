package com.socialnet.amigos.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.socialnet.amigos.entity.Amigos;
import com.socialnet.amigos.entity.SolicitudesAmistad;
import com.socialnet.amigos.model.AmigosDto;
import com.socialnet.amigos.model.BusquedaAmigoDto;
import com.socialnet.amigos.model.NuevosAmigosDto;
import com.socialnet.amigos.model.SolicitudesAmistadDto;
import com.socialnet.amigos.model.TemplateResponse;
import com.socialnet.amigos.model.remote.UsuariosDto;
import com.socialnet.amigos.model.remote.async.PostsDto;
import com.socialnet.amigos.repository.AmigosRepository;
import com.socialnet.amigos.repository.SolicitudesAmistadRepository;
import com.socialnet.amigos.service.remote.ClientException;
import com.socialnet.amigos.service.remote.UsuariosServiceRemote;
import com.socialnet.amigos.service.remote.async.EnvioPost;

@Service
public class SolicitudesAmistadServiceImpl implements SolicitudesAmistadService {
	
	@Autowired
	private SolicitudesAmistadRepository amistadRepository;
	@Autowired
	private UsuariosServiceRemote remote;
	@Autowired
	private AmigosRepository amigosRepository;
	@Autowired
	private EnvioPost envioPost;
	Gson json = new Gson();

	@Override
	public SolicitudesAmistad obtenerSolicitudById(String id) {
		// TODO Auto-generated method stub
		return amistadRepository.findById(id)
				.orElseThrow(() -> SolicitudNotFoundException.from("Solicitud No Encontrada", id));
	}

	@Override
	public List<SolicitudesAmistad> obtenerSolicitudesGeneradas(String idUsuario) {
		// TODO Auto-generated method stub
		return amistadRepository.findByUsuarioGenera(idUsuario);
	}

	@Override
	public TemplateResponse crearSolicitud(BusquedaAmigoDto busquedaDto) {
		// TODO Auto-generated method stub
		try {
			TemplateResponse valida1 = remote.existeUsuario(busquedaDto.getUsuarioGenera());
			TemplateResponse valida2 = remote.existeUsuario(busquedaDto.getUsuarioRecibe());
			if("200".equals(valida1.getCodigo()) && "200".equals(valida2.getCodigo())) {
				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> map1 = mapper.convertValue(valida1.getDetalles(), Map.class);
				Map<String, Object> map2 = mapper.convertValue(valida2.getDetalles(), Map.class);
				
				SolicitudesAmistadDto nuevaSolicitud = new SolicitudesAmistadDto();
				nuevaSolicitud.setUsuarioGenera(map1.get("id").toString());
				nuevaSolicitud.setUsuarioRecibe(map2.get("id").toString());
				nuevaSolicitud.setAceptada(Boolean.FALSE);
				
				SolicitudesAmistad amistad = amistadRepository.saveAndFlush(SolicitudesAmistad.from(nuevaSolicitud));
				
				return new TemplateResponse("Solicitud enviada!", "200", amistad);
			}
		} catch (ClientException e) {
			// TODO: handle exception
			throw new SolicitudNotFoundException("Usuarios no encontrados", "404");
		}
		return null;
	}

	@Override
	public List<SolicitudesAmistad> obtenerSolicitudesRecibidas(String idUsuario) {
		// TODO Auto-generated method stub
		return amistadRepository.findByUsuarioRecibe(idUsuario);
	}

	@Override
	public SolicitudesAmistad buscarSolicitud(String usuarioGenera, String usuarioRecibe) {
		// TODO Auto-generated method stub
		return amistadRepository.findSolicitudesByUsuarioGeneraAndUsuarioRecibe(usuarioGenera, usuarioRecibe)
				.orElseThrow(() -> SolicitudNotFoundException.from("Solicitud inexistente", "-1"));
	}

	@Override
	public TemplateResponse procesarSolicitud(String id, boolean aplicar) {
		// TODO Auto-generated method stub
		SolicitudesAmistad amistad = amistadRepository.findById(id)
				.orElseThrow(() -> SolicitudNotFoundException.from("Solicitud no Encontrada", id));
		SolicitudesAmistadDto dto = amistad.to();
		dto.setAceptada(Boolean.valueOf(aplicar));
		amistad = amistadRepository.save(SolicitudesAmistad.from(dto));
		AmigosDto amigosDto = new AmigosDto();
		amigosDto.setIdUsuario(amistad.getUsuarioGenera());
		amigosDto.setIdAmigo(amistad.getUsuarioRecibe());
		amigosDto.setFechaAmistad(new Date().toString());
		amigosDto.setParentesco("Brothers del alma");
		Amigos amigos = amigosRepository.saveAndFlush(Amigos.from(amigosDto));
		PostsDto postsDto = new PostsDto();
		NuevosAmigosDto nuevosAmigosDto = new NuevosAmigosDto();
		postsDto.setFechaPost(amigosDto.getFechaAmistad());
		postsDto.setPropietario(amigosDto.getIdUsuario());
		postsDto.setTitulo("Nueva Amistad");
		postsDto.setAdjunto(amigosDto.getParentesco());
		try {
			UsuariosDto usuario1 = remote.obtenerUsuarios(amigos.getIdUsuario());
			UsuariosDto usuario2 = remote.obtenerUsuarios(amigos.getIdAmigo());
			nuevosAmigosDto.setAmigoTag1(usuario1.getTag());
			nuevosAmigosDto.setAmigoTag2(usuario2.getTag());
			nuevosAmigosDto.setFecha(amigosDto.getFechaAmistad());
			postsDto.setPropietarioTag(usuario1.getTag());
			postsDto.setMensaje(usuario1.getTag() + " y " + usuario2.getTag() + " son amigos ahora!!!");
		} catch (ClientException e) {
			nuevosAmigosDto.setAmigoTag1("Sin info");
			nuevosAmigosDto.setAmigoTag2("Sin info");
			nuevosAmigosDto.setFecha(amigosDto.getFechaAmistad());
			postsDto.setPropietarioTag("Sin info");
			postsDto.setMensaje("Tienes una nueva Amistad");
		}
		envioPost.sendPost(json.toJson(postsDto));
		return new TemplateResponse("Solicitud Procesada", "200", nuevosAmigosDto);
	}

}
