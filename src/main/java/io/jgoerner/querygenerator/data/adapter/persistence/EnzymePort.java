package io.jgoerner.querygenerator.data.adapter.persistence;

import io.jgoerner.querygenerator.data.application.port.out.SaveEnzymePort;
import io.jgoerner.querygenerator.data.domain.Enzyme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnzymePort implements SaveEnzymePort {

    private final EnzymeNeoRepository repository;

    @Override
    public Enzyme save(Enzyme e) {
        var ene = EnzymeNeoEntity.of(e);
        repository.save(ene);
        return e;
    }

}
