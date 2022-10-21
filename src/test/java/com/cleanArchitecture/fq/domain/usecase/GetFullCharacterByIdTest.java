package com.cleanArchitecture.fq.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetFullCharacterByIdTest {
	
	@Autowired
	private IRickAndMortyServiceCharacter rickAndMortyServiceCharacter;
	
	@Autowired
	private IRickAndMortyServiceLocation rickAndMortyServiceLocation;
	
	@Autowired
	private GetFullCharacterByIdById getFullCharacterById;
	
	int idOk = 1;
	int idNOk = -1;
	int idZero = 0;
	Gson gson = new Gson();
	
	@BeforeEach
	public void setUp() {
		getFullCharacterById = new GetFullCharacterByIdById(rickAndMortyServiceCharacter, rickAndMortyServiceLocation);
	}
	
	@Test
	void testgetFinalRootById_when_it_recives_id_ok(){
		Assertions.assertNotNull(getFullCharacterById.getFinalRootById(idOk), GlobalConstants.MUST_BE_A_NOT_NULL);
	}
	
	@Test
	void testgetFinalRootById_when_it_recives_id_not_found() {
		assertNull(getFullCharacterById.getFinalRootById(idNOk), GlobalConstants.MUST_BE_A_NULL);
	}
	
	@Test
	void testgetFinalRootById_when_it_recives_id_zero() {
		assertNull(getFullCharacterById.getFinalRootById(idZero), GlobalConstants.MUST_BE_A_NULL);
	}

	/*
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
