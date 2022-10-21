package com.cleanArchitecture.fq.infraestructure.controller.mapper;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerCharacter;

public interface IMapperControllerRickAndMorty {

    public ModelControllerCharacter entityToModelCharacterController(Character character);

}
