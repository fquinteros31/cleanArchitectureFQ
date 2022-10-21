package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelGatewayLocation {
    private int id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private Date created;
}
