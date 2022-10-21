package com.cleanArchitecture.fq.domain.usecase;

import com.cleanArchitecture.fq.domain.port.input.IUserService;
import com.cleanArchitecture.fq.infraestructure.config.UserDummyConfig;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetUserAndTokenTest {
	
	@Autowired
	private IUserService IUserService;
	
	@Autowired
	private UserDummyConfig userDummyConfig;
		
	@BeforeEach
	public void setUp() {
		
	}

	/*
	@Test
	void testValidateUser_when_is_null(){
		assertFalse(IUserService.validateUser(null));
	}
	
	@Test
	void testValidateUser_when_is_invalid_user(){
		User user = new User();
		user.setUsername("invalidUser");
		user.setPassword("invalidPassword");
		assertFalse(IUserService.validateUser(user));
	}
	
	
	@Test
	void testValidateUser_when_is_a_valid_user(){
		User user = new User();
		user.setUsername(userDummyConfig.getUserDummy());
		user.setPassword(userDummyConfig.getPasswordDummy());
		assertTrue(IUserService.validateUser(user));
	}
	 */
}
