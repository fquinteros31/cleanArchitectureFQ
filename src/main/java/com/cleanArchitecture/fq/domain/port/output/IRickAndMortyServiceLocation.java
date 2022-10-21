package com.cleanArchitecture.fq.domain.port.output;

import com.cleanArchitecture.fq.domain.model.Location;

public interface IRickAndMortyServiceLocation {

	Location getASingleLocation(String url);

}
