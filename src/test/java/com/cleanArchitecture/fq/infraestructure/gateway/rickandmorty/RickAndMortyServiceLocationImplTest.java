package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RickAndMortyServiceLocationImplTest {
	
	
	@Autowired
	private IRickAndMortyServiceLocation rickAndMortyServiceLocation;
	
	@Autowired
	private RestTemplate restTemplate;
	
	String urlOk = "https://rickandmortyapi.com/api/location/1";
	String urlNok = "https://rickandmortyapi.com/api/location/-1";
	
	
	@BeforeEach
	public void setUp() {
		//rickAndMortyServiceLocation = new RickAndMortyServiceLocationImpl(restTemplate);
		//restTemplate = Mockito.mock(RestTemplate.class);
	}
	
	@Test
	void testGetASingleLocation_when_it_recives_url_ok() {
		Location location = rickAndMortyServiceLocation.getASingleLocation(urlOk);
		assertNotNull(location, GlobalConstants.MUST_BE_A_NOT_NULL);
	}
	
	@Test
	void testGetASingleLocation_when_it_recives_url_not_found() {
		assertThrows(HttpClientErrorException.NotFound.class, () -> rickAndMortyServiceLocation.getASingleLocation(urlNok));
	}
	
	@Test
	void testGetASingleLocation_when_it_recives_url_null() {
		assertThrows(IllegalArgumentException.class, () -> rickAndMortyServiceLocation.getASingleLocation(null));
	}
	
	
	
	

}
