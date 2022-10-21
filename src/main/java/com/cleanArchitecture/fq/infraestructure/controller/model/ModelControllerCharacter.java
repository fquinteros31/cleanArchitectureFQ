package com.cleanArchitecture.fq.infraestructure.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelControllerCharacter {

    @NotNull(message = "id is mandatory")
    private int id;
    @NotNull(message = "name is mandatory")
    private String name;
    @NotNull(message = "status is mandatory")
    private String status;
    @NotNull(message = "species is mandatory")
    private String species;
    @NotNull(message = "type is mandatory")
    private String type;
    private int episode_count;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> episode;
    @NotNull
    private ModelControllerLocation location;

    public int getEpisode_count() {
        return episode != null ? episode.size() : 0;
    }


}
