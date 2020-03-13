package io.jgoerner.querygenerator.data.application.port.in;

import io.jgoerner.querygenerator.data.domain.Enzyme;

public interface NewEnzymeUseCase {

    Enzyme create(String name, String abbreviation);
}
