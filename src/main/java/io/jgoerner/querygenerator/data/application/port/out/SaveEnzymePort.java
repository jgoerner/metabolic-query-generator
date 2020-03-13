package io.jgoerner.querygenerator.data.application.port.out;

import io.jgoerner.querygenerator.data.domain.Enzyme;

public interface SaveEnzymePort {

    Enzyme save(Enzyme e);
}
