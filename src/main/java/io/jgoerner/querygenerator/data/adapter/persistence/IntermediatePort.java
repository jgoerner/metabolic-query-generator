package io.jgoerner.querygenerator.data.adapter.persistence;

import io.jgoerner.querygenerator.data.application.port.out.SaveIntermediatePort;
import io.jgoerner.querygenerator.data.domain.Intermediate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntermediatePort implements SaveIntermediatePort {

    private final IntermediateNeoRepository repository;

    @Override
    public Intermediate save(Intermediate i) {
        var ine = IntermediateNeoEntity.of(i);
        repository.save(ine);
        return i;
    }
}
