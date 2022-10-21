package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper;

import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model.ModelGatewayLocation;
import org.modelmapper.ModelMapper;

public class MapperLocationGatewayEntity implements IMapperLocationGatewayEntity{

    private ModelMapper modelMapper;

    public MapperLocationGatewayEntity(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Location modelToEntityLocationGateway(ModelGatewayLocation modelGatewayLocation) {
        return modelMapper.map(modelGatewayLocation, Location.class);
    }
}
