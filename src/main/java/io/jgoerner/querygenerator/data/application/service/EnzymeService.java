package io.jgoerner.querygenerator.data.application.service;

import io.jgoerner.querygenerator.data.application.port.in.NewEnzymeUseCase;
import io.jgoerner.querygenerator.data.application.port.out.SaveEnzymePort;
import io.jgoerner.querygenerator.data.domain.Enzyme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnzymeService implements NewEnzymeUseCase {

    private final SaveEnzymePort saveEnzymePort;

    @Override
    public Enzyme create(String name, String abbreviation) {
        var enzyme = new Enzyme(name, abbreviation);
        return saveEnzymePort.save(enzyme);
    }
}
