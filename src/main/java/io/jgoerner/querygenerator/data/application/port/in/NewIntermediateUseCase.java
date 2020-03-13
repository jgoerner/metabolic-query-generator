package io.jgoerner.querygenerator.data.application.port.in;

import io.jgoerner.querygenerator.data.domain.Intermediate;

public interface NewIntermediateUseCase {

    Intermediate create(String name, String abbreviation);
}
