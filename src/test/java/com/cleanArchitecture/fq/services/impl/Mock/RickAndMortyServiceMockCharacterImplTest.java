package com.cleanArchitecture.fq.services.impl.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.cleanArchitecture.fq.JsonDummies;
import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.infraestructure.config.EndPointConfig;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.exception.CharacterNotFoundException;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

@SpringJUnitConfig
class RickAndMortyServiceMockCharacterImplTest {

	@MockBean
	private IRickAndMortyServiceCharacter rickAndMortyServiceCharacter;

	@Mock
	private RestTemplate restTemplate;

	@Mock
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
		when(rickAndMortyServiceCharacter.getASingleCharacterById(idOk)).thenReturn(JsonDummies.getRootDummyOk());
		Character character = rickAndMortyServiceCharacter.getASingleCharacterById(idOk);
		assertNotNull(character, GlobalConstants.MUST_BE_A_NOT_NULL);
	}
	
	@Test
	void testGetASingleCharacter_when_it_recives_id_not_found() {
		when(rickAndMortyServiceCharacter.getASingleCharacterById(idNOk)).thenThrow(CharacterNotFoundException.class);
		assertThrows(CharacterNotFoundException.class, () -> rickAndMortyServiceCharacter.getASingleCharacterById(idNOk));
	}
	
	@Test
	void testGetASingleCharacter_when_it_recives_id_zero() {
		when(rickAndMortyServiceCharacter.getASingleCharacterById(idZero)).thenThrow(CharacterNotFoundException.class);
		assertThrows(CharacterNotFoundException.class, () -> rickAndMortyServiceCharacter.getASingleCharacterById(idZero));
	}

}
