package com.cleanArchitecture.fq.infraestructure.controller.mapper;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerCharacter;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerLocation;
import org.springframework.stereotype.Component;

@Component
public class MapperControllerRickAndMorty implements IMapperControllerRickAndMorty {


    @Override
    public ModelControllerCharacter entityToModelCharacterController(Character character){
        ModelControllerCharacter modelControllerCharacter = new ModelControllerCharacter();
        modelControllerCharacter.setId(character.getId());
        modelControllerCharacter.setName(character.getName());
        modelControllerCharacter.setStatus(character.getStatus());
        modelControllerCharacter.setSpecies(character.getSpecies());
        modelControllerCharacter.setType(character.getType());
        //modelControllerCharacter.setEpisode_count();
        modelControllerCharacter.setEpisode(character.getEpisode());
        modelControllerCharacter.setLocation(entityToModelLocationController(character.getLocation()));

        return modelControllerCharacter;
    }

    private ModelControllerLocation entityToModelLocationController(Location location){
        ModelControllerLocation modelControllerLocation = new ModelControllerLocation();
        modelControllerLocation.setName(location.getName());
        modelControllerLocation.setUrl(location.getUrl());
        modelControllerLocation.setDimension(location.getDimension());
        modelControllerLocation.setResidents(location.getResidents());

        return modelControllerLocation;
    }

}
