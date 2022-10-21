package com.cleanArchitecture.fq.infraestructure.controller;

import com.cleanArchitecture.fq.domain.port.input.IGetFullCharacterById;
import com.cleanArchitecture.fq.infraestructure.controller.mapper.IMapperControllerRickAndMorty;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerCharacter;
import javax.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/RickAndMorty/v1")
@Validated
public class RickAndMortyController {

	private IGetFullCharacterById rickAndMortyServices;
	private IMapperControllerRickAndMorty mapperController;

	public RickAndMortyController(IGetFullCharacterById rickAndMortyServices, IMapperControllerRickAndMorty mapperController) {
		this.rickAndMortyServices = rickAndMortyServices;
		this.mapperController = mapperController;
	}

	@GetMapping(value = "/getCharacter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelControllerCharacter> getASingleCharacter(@PathVariable @Min(1) int id) {
		return ResponseEntity.status(HttpStatus.OK).body(mapperController.entityToModelCharacterController(rickAndMortyServices.getFinalRootById(id)));
	}

}
