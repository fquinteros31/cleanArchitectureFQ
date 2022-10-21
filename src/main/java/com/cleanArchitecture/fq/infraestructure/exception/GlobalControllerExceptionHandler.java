package com.cleanArchitecture.fq.infraestructure.exception;

import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.exception.CharacterNotFoundException;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCharacterNotFound(CharacterNotFoundException ex) {
        ApiResponse errorObj = new ApiResponse();
        errorObj.setStatus(HttpStatus.NOT_FOUND.value());
        errorObj.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCharacterNotFound(UserNotFoundException ex) {
        ApiResponse errorObj = new ApiResponse();
        errorObj.setStatus(HttpStatus.NOT_FOUND.value());
        errorObj.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
}
