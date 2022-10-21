package com.cleanArchitecture.fq.domain.port.output;

import com.cleanArchitecture.fq.domain.model.Character;

public interface IRickAndMortyServiceCharacter {

	Character getASingleCharacterById(int id);

}
