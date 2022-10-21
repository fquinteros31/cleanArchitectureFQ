package com.cleanArchitecture.fq.domain.port.input;

import com.cleanArchitecture.fq.domain.model.User;

public interface IUserService {

	User getUserAndToken(User user);

}
