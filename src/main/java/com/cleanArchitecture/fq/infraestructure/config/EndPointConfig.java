package com.cleanArchitecture.fq.infraestructure.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EndPointConfig {
	
	@Value("${host.api.rickAndMorty}")
	private String apiHost;

	@Value("${api.character}")
	private String character;

}
