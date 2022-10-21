package com.cleanArchitecture.fq.infraestructure.controller.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelControllerLocation {


    private static final long serialVersionUID = -1089002746336563887L;
    @NotNull(message = "name is mandatory")
    private String name;
    @NotNull(message = "url is mandatory")
    private String url;
    @NotNull(message = "dimension is mandatory")
    private String dimension;
    @NotNull(message = "residents is mandatory")
    private List<String> residents;


}
