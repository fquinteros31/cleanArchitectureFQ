package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.infraestructure.config.EndPointConfig;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.exception.CharacterNotFoundException;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper.IMapperCharacterGatewayEntity;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model.ModelGatewayCharacter;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickAndMortyServiceCharacterImpl implements IRickAndMortyServiceCharacter {

	private RestTemplate restTemplate;
	private EndPointConfig endPointConfig;
	private IMapperCharacterGatewayEntity mapperCharacterGatewayEntity;

	public RickAndMortyServiceCharacterImpl(RestTemplate restTemplate, EndPointConfig endPointConfig, IMapperCharacterGatewayEntity mapperCharacterGatewayEntity) {
		this.restTemplate = restTemplate;
		this.endPointConfig = endPointConfig;
		this.mapperCharacterGatewayEntity = mapperCharacterGatewayEntity;
	}

	/*
	@Override
	public Character getASingleCharacterById(int id) {
		String url = endPointConfig.getApiHost() + endPointConfig.getCharacter() + id;
		Character character = null;
		try {
			character = restTemplate.getForObject(url, Character.class);
		}catch (Exception e){
			throw new CharacterNotFoundException(GlobalConstants.CHARACTER_NOT_FOUND);
		}
		return character;
	}

	 */

	@Override
	public Character getASingleCharacterById(int id) {
		String url = endPointConfig.getApiHost() + endPointConfig.getCharacter() + id;
		ModelGatewayCharacter modelGatewayCharacter = null;
		Character character = null;
		try {
			modelGatewayCharacter = restTemplate.getForObject(url, ModelGatewayCharacter.class);
			character = mapperCharacterGatewayEntity.modelToEntityCharacterGateway(modelGatewayCharacter);
		}catch (Exception e){
			e.printStackTrace();
			throw new CharacterNotFoundException(GlobalConstants.CHARACTER_NOT_FOUND);
		}
		return character;
	}

}
