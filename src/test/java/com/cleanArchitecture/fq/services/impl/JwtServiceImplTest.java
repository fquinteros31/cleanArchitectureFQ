package com.cleanArchitecture.fq.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.cleanArchitecture.fq.infraestructure.services.impl.JwtServiceImpl;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtServiceImplTest {

	@Autowired
	private JwtServiceImpl jwtServiceImpl;

	@Test
	void testgetFinalRootMapById_when_recive_null() {
		Assertions.assertNull(jwtServiceImpl.getJWTToken(null), GlobalConstants.MUST_BE_A_NULL);
	}

	@Test
	void testgetFinalRootMapById_when_recive_Blank() {
		assertNull(jwtServiceImpl.getJWTToken(""), GlobalConstants.MUST_BE_A_NULL);
	}

	@Test
	void testgetFinalRootMapById_when_recive_data() {
		assertNotNull(jwtServiceImpl.getJWTToken("admin"), GlobalConstants.MUST_BE_A_NOT_NULL);
	}

}
