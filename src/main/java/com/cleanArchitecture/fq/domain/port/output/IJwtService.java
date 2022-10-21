package com.cleanArchitecture.fq.domain.port.output;

public interface IJwtService {

    public String getJWTToken(String username);
}
