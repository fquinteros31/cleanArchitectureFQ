package com.cleanArchitecture.fq.domain.usecase;

import com.cleanArchitecture.fq.domain.model.Character;
import com.cleanArchitecture.fq.domain.model.Location;
import com.cleanArchitecture.fq.domain.port.input.IGetFullCharacterById;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceCharacter;
import com.cleanArchitecture.fq.domain.port.output.IRickAndMortyServiceLocation;

public class GetFullCharacterByIdById implements IGetFullCharacterById {

	private IRickAndMortyServiceCharacter rickAndMortyServiceCharacter;
	private IRickAndMortyServiceLocation rickAndMortyServiceLocation;

	public GetFullCharacterByIdById(IRickAndMortyServiceCharacter rickAndMortyServiceCharacter,
									IRickAndMortyServiceLocation rickAndMortyServiceLocation) {
		this.rickAndMortyServiceCharacter = rickAndMortyServiceCharacter;
		this.rickAndMortyServiceLocation = rickAndMortyServiceLocation;
	}

	public Character getFinalRootById(int id) {
		Character character = null;
		character = rickAndMortyServiceCharacter.getASingleCharacterById(id);
		Location location = rickAndMortyServiceLocation.getASingleLocation(character.getLocation().getUrl());
		character.setLocation(location);
		return character;
	}


	/*
	public boolean isvalidRoot(Root root) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Root>> violations = validator.validate(root);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<>(violations));
		} else {
			return true;
		}
	}

	 */

}
