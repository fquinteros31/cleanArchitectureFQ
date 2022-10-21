package com.cleanArchitecture.fq.domain.port.input;

import com.cleanArchitecture.fq.domain.model.Character;

public interface IGetFullCharacterById {

    public Character getFinalRootById(int id);
}
