package com.cleanArchitecture.fq.domain.model;

import java.util.Objects;


public class User {
	
	private String username;
	private String password;
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(token, user.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, password, token);
	}
}
