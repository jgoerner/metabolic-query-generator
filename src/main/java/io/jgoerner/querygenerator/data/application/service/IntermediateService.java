package io.jgoerner.querygenerator.data.application.service;

import io.jgoerner.querygenerator.data.application.port.in.NewIntermediateUseCase;
import io.jgoerner.querygenerator.data.application.port.out.SaveIntermediatePort;
import io.jgoerner.querygenerator.data.domain.Intermediate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntermediateService implements NewIntermediateUseCase {

    private final SaveIntermediatePort saveIntermediatePort;

    @Override
    public Intermediate create(String name, String abbreviation) {
        var intermediate = new Intermediate(name, abbreviation);
        return saveIntermediatePort.save(intermediate);
    }
}
