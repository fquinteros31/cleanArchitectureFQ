package com.cleanArchitecture.fq.infraestructure.controller.mapper;

import com.cleanArchitecture.fq.domain.model.User;
import com.cleanArchitecture.fq.infraestructure.controller.model.ModelControllerUser;

public interface IMapperControllerUser {

    public ModelControllerUser entityToModelUserController(User user);
    public User modelToentityUserController(ModelControllerUser modelControllerUser);
}
