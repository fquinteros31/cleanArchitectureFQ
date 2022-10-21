package com.cleanArchitecture.fq.infraestructure.config;

import com.cleanArchitecture.fq.domain.port.output.IJwtService;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;
import com.cleanArchitecture.fq.domain.usecase.GetFullCharacterByIdById;
import com.cleanArchitecture.fq.domain.usecase.GetUserAndToken;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper.MapperCharacterGatewayEntity;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper.MapperLocationGatewayEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {


    @Bean
    public EndPointConfig endPointConfig() {
        return new EndPointConfig();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public MapperCharacterGatewayEntity mapperCharacterGatewayEntity(ModelMapper modelMapper) {
        return new MapperCharacterGatewayEntity(modelMapper);
    }

    /*
    @Bean
    public MapperController mapperController() {
        return new MapperController();
    }
     */

    @Bean
    public MapperLocationGatewayEntity mapperLocationGatewayEntity(ModelMapper modelMapper) {
        return new MapperLocationGatewayEntity(modelMapper);
    }

    /*
    @Bean
    public IRickAndMortyServiceCharacter rickAndMortyServiceCharacter() {
        return new RickAndMortyServiceCharacterImpl(restTemplate(), endPointConfig(), mapperCharacterGatewayEntity());
    }

    @Bean
    public IRickAndMortyServiceLocation rickAndMortyServiceLocation() {
        return new RickAndMortyServiceLocationImpl(restTemplate(), mapperLocationGatewayEntity());
    }

    @Bean
    public GetFullCharacterByIdById getFullCharacterByIdById() {
        return new GetFullCharacterByIdById(rickAndMortyServiceCharacter(),rickAndMortyServiceLocation());
    }
    */

    @Bean
    public GetFullCharacterByIdById getFullCharacterByIdById(IRickAndMortyServiceCharacter rickAndMortyServiceCharacter, IRickAndMortyServiceLocation rickAndMortyServiceLocation) {
        return new GetFullCharacterByIdById(rickAndMortyServiceCharacter,rickAndMortyServiceLocation);
    }

    @Bean
    public GetUserAndToken getUserAndToken(IJwtService jwtServices, UserDummyConfig userDummyConfig){
        return new GetUserAndToken(jwtServices, userDummyConfig);
    }
}
