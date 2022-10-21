package com.cleanArchitecture.fq.domain.usecase.mock;

import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;
import com.cleanArchitecture.fq.domain.usecase.GetFullCharacterByIdById;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(MockitoExtension.class)
@SpringJUnitConfig
class GetFullCharacterByIdMockImplTest {
	
	@Mock
	private IRickAndMortyServiceCharacter rickAndMortyServiceCharacter;
	
	@Mock
	private IRickAndMortyServiceLocation rickAndMortyServiceLocation;

	@MockBean
	private GetFullCharacterByIdById getFullCharacterById;
	
	int idOk = 1;
	int idNOk = -1;
	int idZero = 0;
	String urlOk = "https://rickandmortyapi.com/api/location/1";
	String urlNok = "https://rickandmortyapi.com/api/location/-1";

	Gson gson = new Gson();
	
	@BeforeEach
	public void setUp() {
		getFullCharacterById = new GetFullCharacterByIdById(rickAndMortyServiceCharacter, rickAndMortyServiceLocation);
	}

	/*
	@Test
	void testgetFinalRootById_when_it_recives_id_ok(){
		when(rickAndMortyServiceCharacter.getASingleCharacterById(idOk)).thenReturn(JsonDummies.getRootDummyOk());
		when(rickAndMortyServiceLocation.getASingleLocation(anyString())).thenReturn(JsonDummies.getOriginOk());
		when(getFullCharacterById.getFinalRootById(idOk)).thenReturn(JsonDummies.getRootDummyOk());
		verify(rickAndMortyServiceLocation).getASingleLocation(anyString());
		assertNotNull(getFullCharacterById.getFinalRootById(idOk), GlobalConstants.MUST_BE_A_NOT_NULL);
	}


	@Test
	void testgetFinalRootById_when_it_recives_id_not_found() {
		assertNull(getFullCharacterById.getFinalRootById(idNOk), GlobalConstants.MUST_BE_A_NULL);
	}
	
	@Test
	void testgetFinalRootById_when_it_recives_id_zero() {
		assertNull(getFullCharacterById.getFinalRootById(idZero), GlobalConstants.MUST_BE_A_NULL);
	}


	@Test
	void testValidateRoot_ok() {
		Root root = JsonDummies.getRootDummyOk();
		assertTrue(rickAndMortyImpl.isvalidRoot(root), GlobalConstants.MUST_BE_A_NULL);
	}
	
	@Test
	void testValidateRoot_with_out_name() {
		Root root = JsonDummies.getRootDummyWithOutName();
		assertThrows(ConstraintViolationException.class, () -> rickAndMortyImpl.isvalidRoot(root));
	}
	
	@Test
	void testValidateRoot_with_out_origin() {
		Root root = JsonDummies.getRootDummyWithOutOrigin();
		assertThrows(ConstraintViolationException.class, () -> rickAndMortyImpl.isvalidRoot(root));
	}
	 */


}
