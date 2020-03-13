package io.jgoerner.querygenerator.data.adapter.auto;

import io.jgoerner.querygenerator.data.application.port.in.NewEnzymeUseCase;
import io.jgoerner.querygenerator.data.application.port.in.NewIntermediateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Log4j2
@RequiredArgsConstructor
public class InitialDataLoader implements CommandLineRunner {

    private final NewEnzymeUseCase newEnzymeUseCase;
    private final NewIntermediateUseCase newIntermediateUseCase;

    @Override
    public void run(String... args) throws Exception {
        // Enzymes
        Map.of(
                "Hexokinase", "HK",
                "Phosphofructokinase", "PFK",
                "Glycerinaldehyd-3-phosphat-Dehydrogenase", "GAP-DH",
                "Phosphoglyceratkinase", "PGK",
                "Pyruvatdehydrogenase", "PDH",
                "Pyruvatkinase", "PK",
                "Lactathydrogenase", "LDH",
                "2-Phosphoglycerat", "2-PG",
                "Phosphoenolpyruvat", "PEP"
        ).forEach(newEnzymeUseCase::create);

        // Intermediates
        Map.of(
                "Glucose", "Glc",
                "Glucose-6-phosphat", "Glc-6-P",
                "Fructose-6-phosphat", "Frc-6-P",
                "Fructose-3-phosphat", "Frc-3-P",
                "Fructose", "Frc",
                "Fructose-1,6-phosphat", "FBP",
                "Dihydroxyacetonphosphat", "DHAP",
                "Glycerinaldehyd-3-phosphat", "GAP",
                "1,3-Biphosphoglycerat", "1,3-BPG",
                "3-Phosphoglycerat", "3-PG"
        ).forEach(newIntermediateUseCase::create);
    }
}
