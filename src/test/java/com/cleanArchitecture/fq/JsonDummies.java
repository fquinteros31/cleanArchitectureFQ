package com.cleanArchitecture.fq;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.domain.model.Location;
import com.google.gson.Gson;

public class JsonDummies {

	private static Gson gson = new Gson();

	public static Character getRootDummyOk() {
		String json = "{\"id\":24,\"name\":\"Armagheadon\",\"status\":\"Alive\",\"species\":\"Alien\",\"type\":\"Cromulon\",\"episode_count\":1,\"origin\":{\"name\":\"Signus5Expanse\",\"url\":\"https://rickandmortyapi.com/api/location/22\",\"dimension\":\"CromulonDimension\",\"residents\":[\"https://rickandmortyapi.com/api/character/24\",\"https://rickandmortyapi.com/api/character/309\"]}}";
		Character character = gson.fromJson(json, Character.class);
		return character;
	}

	public static Character getRootDummyWithOutName() {
		String json = "{\"id\":24,\"status\":\"Alive\",\"species\":\"Alien\",\"type\":\"Cromulon\",\"episode_count\":1,\"origin\":{\"name\":\"Signus5Expanse\",\"url\":\"https://rickandmortyapi.com/api/location/22\",\"dimension\":\"CromulonDimension\",\"residents\":[\"https://rickandmortyapi.com/api/character/24\",\"https://rickandmortyapi.com/api/character/309\"]}}";
		Character character = gson.fromJson(json, Character.class);
		return character;
	}

	public static Character getRootDummyWithOutOrigin() {
		String json = "{\"id\":24,\"name\":\"Armagheadon\",\"status\":\"Alive\",\"species\":\"Alien\",\"type\":\"Cromulon\",\"episode_count\":1}";
		Character character = gson.fromJson(json, Character.class);
		return character;
	}

	public static String getJsonUserDummyOk() {
		return "{\"username\":\"admin\",\"password\":\"password\"}";
	}

	public static String getJsonUserDummyNOk() {
		return "{\"username\":\"invalidUser\",\"password\":\"invalidPassword\"}";
	}

	public static Location getOriginOk() {
		String json = "{\"id\":1,\"name\":\"Earth (C-137)\",\"type\":\"Planet\",\"dimension\":\"Dimension C-137\",\"residents\":[\"https://rickandmortyapi.com/api/character/38\",\"https://rickandmortyapi.com/api/character/45\",\"https://rickandmortyapi.com/api/character/71\",\"https://rickandmortyapi.com/api/character/82\",\"https://rickandmortyapi.com/api/character/83\",\"https://rickandmortyapi.com/api/character/92\",\"https://rickandmortyapi.com/api/character/112\",\"https://rickandmortyapi.com/api/character/114\",\"https://rickandmortyapi.com/api/character/116\",\"https://rickandmortyapi.com/api/character/117\",\"https://rickandmortyapi.com/api/character/120\",\"https://rickandmortyapi.com/api/character/127\",\"https://rickandmortyapi.com/api/character/155\",\"https://rickandmortyapi.com/api/character/169\",\"https://rickandmortyapi.com/api/character/175\",\"https://rickandmortyapi.com/api/character/179\",\"https://rickandmortyapi.com/api/character/186\",\"https://rickandmortyapi.com/api/character/201\",\"https://rickandmortyapi.com/api/character/216\",\"https://rickandmortyapi.com/api/character/239\",\"https://rickandmortyapi.com/api/character/271\",\"https://rickandmortyapi.com/api/character/302\",\"https://rickandmortyapi.com/api/character/303\",\"https://rickandmortyapi.com/api/character/338\",\"https://rickandmortyapi.com/api/character/343\",\"https://rickandmortyapi.com/api/character/356\",\"https://rickandmortyapi.com/api/character/394\"],\"url\":\"https://rickandmortyapi.com/api/location/1\",\"created\":\"2017-11-10T12:42:04.162Z\"}";
		Location location = gson.fromJson(json, Location.class);
		return location;
	}
}
