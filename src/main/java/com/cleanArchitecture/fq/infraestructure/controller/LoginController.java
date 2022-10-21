package com.cleanArchitecture.fq.infraestructure.controller;

import com.cleanArchitecture.fq.infraestructure.controller.mapper.IMapperControllerUser;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerUser;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class LoginController {

	private com.cleanArchitecture.fq.domain.port.input.IUserService IUserService;
	IMapperControllerUser mapperControllerUser;

	public LoginController(com.cleanArchitecture.fq.domain.port.input.IUserService IUserService, IMapperControllerUser mapperControllerUser) {
		this.IUserService = IUserService;
		this.mapperControllerUser = mapperControllerUser;
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelControllerUser> login(@Valid @RequestBody ModelControllerUser modelControllerUser) {
		return ResponseEntity.status(HttpStatus.OK).body(mapperControllerUser.entityToModelUserController(IUserService.getUserAndToken(mapperControllerUser.modelToentityUserController(modelControllerUser))));
	}

}
