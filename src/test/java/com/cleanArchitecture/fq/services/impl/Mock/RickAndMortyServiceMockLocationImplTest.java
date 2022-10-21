package com.cleanArchitecture.fq.services.impl.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.cleanArchitecture.fq.JsonDummies;
import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

@SpringJUnitConfig
class RickAndMortyServiceMockLocationImplTest {
	
	
	@MockBean
	private IRickAndMortyServiceLocation rickAndMortyServiceLocation;
	
	@Mock
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
		when(rickAndMortyServiceLocation.getASingleLocation(urlOk)).thenReturn(JsonDummies.getOriginOk());
		Location location = rickAndMortyServiceLocation.getASingleLocation(urlOk);
		assertNotNull(location, GlobalConstants.MUST_BE_A_NOT_NULL);
	}
	
	@Test
	void testGetASingleLocation_when_it_recives_url_not_found() {
		Location location = new Location();

		when(rickAndMortyServiceLocation.getASingleLocation(urlNok)).thenReturn(location);
		Location locationReturn = rickAndMortyServiceLocation.getASingleLocation(urlNok);
		assertEquals(location, locationReturn);
	}
	
	@Test
	void testGetASingleLocation_when_it_recives_url_null() {
		Location location = new Location();

		when(rickAndMortyServiceLocation.getASingleLocation(null)).thenReturn(location);
		Location locationReturn = rickAndMortyServiceLocation.getASingleLocation(null);
		assertEquals(location, locationReturn);
	}
	
	
	
	

}
