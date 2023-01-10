package com.socialnet.login.api;

import static org.springframework.http.HttpStatus.OK;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.socialnet.login.model.LoginInfoDto;
import com.socialnet.login.model.RespuestaDto;
import com.socialnet.login.model.TemplateResponse;
import com.socialnet.login.service.LoginServiceImpl;

@RestController
@RequestMapping("login/v1")
public class LoginController {
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	private Logger LOG = Logger.getLogger(LoginController.class);
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public RespuestaDto getUsuario(@PathVariable("id")String id) {
		LOG.info(">>> Servicio getUsuario");
		return loginServiceImpl.pruebaRemoteService(id);
	}
	
	@GetMapping("/verifica/{mail}")
	@ResponseStatus(OK)
	public TemplateResponse verificaUsuario(@PathVariable("mail") String mail) {
		LOG.info(">>> Servicio verificaUsuario");
		return loginServiceImpl.existeUsuario(mail);
	}
	
	@PostMapping
	@ResponseStatus(OK)
	public TemplateResponse validaLogin(@RequestBody LoginInfoDto infoDto) {
		LOG.info(">>> Servicio validaLogin");
		return loginServiceImpl.loginOk(infoDto);
	}
}
