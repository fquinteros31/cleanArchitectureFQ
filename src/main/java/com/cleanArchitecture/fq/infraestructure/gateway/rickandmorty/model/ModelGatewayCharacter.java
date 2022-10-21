package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelGatewayCharacter {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private ModelGatewayOrigin origin;
    private ModelGatewayLocation location;
    private String image;
    private List<String> episode;
    private String url;




}
