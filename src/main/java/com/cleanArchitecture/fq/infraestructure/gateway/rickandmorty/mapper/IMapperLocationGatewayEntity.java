package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper;

import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model.ModelGatewayLocation;

public interface IMapperLocationGatewayEntity {

    public Location modelToEntityLocationGateway(ModelGatewayLocation modelGatewayLocation);
}
