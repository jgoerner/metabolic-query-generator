package io.jgoerner.querygenerator.data.adapter.web;

import io.jgoerner.querygenerator.data.application.port.in.NewEnzymeUseCase;
import io.jgoerner.querygenerator.data.domain.Enzyme;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnzymeController {

    private final NewEnzymeUseCase newEnzymeUseCase;

    @PostMapping("enzymes")
    Enzyme create(@RequestParam("name") String name, @RequestParam("abbr") String abbreviation){
        return newEnzymeUseCase.create(name, abbreviation);
    }

}
