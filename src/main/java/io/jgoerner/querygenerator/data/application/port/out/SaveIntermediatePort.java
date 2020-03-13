package io.jgoerner.querygenerator.data.application.port.out;

import io.jgoerner.querygenerator.data.domain.Intermediate;

public interface SaveIntermediatePort {

    Intermediate save(Intermediate i);
}
