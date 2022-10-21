package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelGatewayOrigin {
    private String name;
    private String url;
}
