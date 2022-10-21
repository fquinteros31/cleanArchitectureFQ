package com.cleanArchitecture.fq.infraestructure.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UserDummyConfig {
	
	@Value("${login.user.dummy}")
	private String userDummy;

	@Value("${login.password.dummy}")
	private String passwordDummy;

}
