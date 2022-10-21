package com.cleanArchitecture.fq.domain.usecase;

import com.cleanArchitecture.fq.domain.model.User;
import com.cleanArchitecture.fq.domain.port.input.IUserService;
import com.cleanArchitecture.fq.domain.port.output.IJwtService;
import com.cleanArchitecture.fq.infraestructure.config.UserDummyConfig;
import com.cleanArchitecture.fq.infraestructure.gateway.rickandmorty.exception.UserNotFoundException;
import com.cleanArchitecture.fq.infraestructure.util.GlobalConstants;

public class GetUserAndToken implements IUserService {

	private IJwtService jwtServices;
	private UserDummyConfig userDummyConfig;


	public GetUserAndToken(IJwtService jwtServices, UserDummyConfig userDummyConfig) {
		this.jwtServices = jwtServices;
		this.userDummyConfig = userDummyConfig;
	}

	private boolean validateUser(User user) {
		User validUser = findValidUser();
		return (user != null && user.equals(validUser));
	}

	@Override
	public User getUserAndToken(User user) {
		if (validateUser(user)) {
			String token = jwtServices.getJWTToken(user.getUsername());
			User userResponse = new User();
			userResponse.setUsername(user.getUsername());
			userResponse.setToken(token);
			return userResponse;
		} else {
			throw new UserNotFoundException(GlobalConstants.ERROR_LOGIN);
		}
	}

	private User findValidUser() {
		User user = new User();
		user.setUsername(userDummyConfig.getUserDummy());
		user.setPassword(userDummyConfig.getPasswordDummy());
		return user;
	}

}
