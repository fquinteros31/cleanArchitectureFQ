package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty;

import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.mapper.IMapperLocationGatewayEntity;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.model.ModelGatewayLocation;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RickAndMortyServiceLocationImpl implements IRickAndMortyServiceLocation {

	private RestTemplate restTemplate;
	private IMapperLocationGatewayEntity mapperLocationGatewayEntity;

	public RickAndMortyServiceLocationImpl(RestTemplate restTemplate, IMapperLocationGatewayEntity mapperLocationGatewayEntity) {
		this.restTemplate = restTemplate;
		this.mapperLocationGatewayEntity = mapperLocationGatewayEntity;
	}

	/*
	@Override
	public Location getASingleLocation(String url) {
		Location location = null;
		try{
			location = restTemplate.getForObject(url, Location.class);
		}catch (Exception e){
			location = new Location("","","",new ArrayList<>());
		}
		return location;
	}
	 */

	@Override
	public Location getASingleLocation(String url) {
		Location location = null;
		ModelGatewayLocation modelGatewayLocation = null;
		try{
			modelGatewayLocation = restTemplate.getForObject(url, ModelGatewayLocation.class);
			location = mapperLocationGatewayEntity.modelToEntityLocationGateway(modelGatewayLocation);
		}catch (Exception e){
			e.printStackTrace();
			location = new Location(0, "", "", "", new ArrayList<>(), "", null);
		}
		return location;
	}

}
