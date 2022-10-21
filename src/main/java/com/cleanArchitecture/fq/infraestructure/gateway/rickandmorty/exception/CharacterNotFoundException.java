package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CharacterNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -4653739789069308056L;

    public CharacterNotFoundException(String message){
        super(message);
    }

}
