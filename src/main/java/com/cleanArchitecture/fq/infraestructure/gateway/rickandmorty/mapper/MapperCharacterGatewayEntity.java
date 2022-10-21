package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper;


import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model.ModelGatewayCharacter;
import org.modelmapper.ModelMapper;

public class MapperCharacterGatewayEntity implements IMapperCharacterGatewayEntity{

    private ModelMapper modelMapper;

    public MapperCharacterGatewayEntity(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Character modelToEntityCharacterGateway(ModelGatewayCharacter modelGatewayCharacter) {
        return modelMapper.map(modelGatewayCharacter,Character.class);
    }
}
