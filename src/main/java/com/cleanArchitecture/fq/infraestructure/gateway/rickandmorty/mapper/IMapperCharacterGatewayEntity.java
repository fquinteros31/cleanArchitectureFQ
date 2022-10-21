package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model.ModelGatewayCharacter;

public interface IMapperCharacterGatewayEntity {

    public Character modelToEntityCharacterGateway(ModelGatewayCharacter modelGatewayCharacter);
}
