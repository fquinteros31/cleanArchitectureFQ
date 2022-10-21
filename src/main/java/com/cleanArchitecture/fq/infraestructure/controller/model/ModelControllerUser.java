package com.cleanArchitecture.fq.infraestructure.controller.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class ModelControllerUser {


    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String token;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelControllerUser modelControllerUser = (ModelControllerUser) o;
        return Objects.equals(username, modelControllerUser.username) && Objects.equals(password, modelControllerUser.password) && Objects.equals(token, modelControllerUser.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, token);
    }

}
