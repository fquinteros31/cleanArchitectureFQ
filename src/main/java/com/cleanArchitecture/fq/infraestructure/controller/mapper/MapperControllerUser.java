package com.cleanArchitecture.fq.infraestructure.controller.mapper;

import com.cleanArchitecture.fq.domain.model.User;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperControllerUser implements IMapperControllerUser{

    private ModelMapper modelMapper;

    public MapperControllerUser(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelControllerUser entityToModelUserController(User user) {
        return modelMapper.map(user, ModelControllerUser.class);
    }

    @Override
    public User modelToentityUserController(ModelControllerUser modelControllerUser) {
        return modelMapper.map(modelControllerUser, User.class);
    }
}
