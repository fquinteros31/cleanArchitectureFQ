package com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.infraestructure.config.EndPointConfig;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringJUnitConfig
@SpringBootTest
class RickAndMortyServiceCharacterImplTest {
	
	@Autowired
	private IRickAndMortyServiceCharacter rickAndMortyServiceCharacter;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	EndPointConfig endPointConfig;
	
	int idOk = 1;
	int idNOk = -1;
	int idZero = 0;
	
	
	@BeforeEach
	public void setUp() {
		//rickAndMortyServiceCharacter = new RickAndMortyServiceCharacterImpl(restTemplate, endPointConfig);
	}
	
	@Test
	void testGetASingleCharacter_when_it_recives_id_ok() {
		Character character = rickAndMortyServiceCharacter.getASingleCharacterById(idOk);
		assertNotNull(character, GlobalConstants.MUST_BE_A_NOT_NULL);
	}
	
	@Test
	void testGetASingleCharacter_when_it_recives_id_not_found() {
		assertThrows(HttpClientErrorException.NotFound.class, () -> rickAndMortyServiceCharacter.getASingleCharacterById(idNOk));
	}
	
	@Test
	void testGetASingleCharacter_when_it_recives_id_zero() {
		assertThrows(HttpClientErrorException.NotFound.class, () -> rickAndMortyServiceCharacter.getASingleCharacterById(idZero));
	}

}
