package io.jgoerner.querygenerator.questions.adapter.persistence;

import io.jgoerner.querygenerator.questions.application.port.out.SaveAnswerPort;
import io.jgoerner.querygenerator.questions.domain.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerPort implements SaveAnswerPort {

    private final AnswerPostgresRepository repository;

    @Override
    public Answer save(Answer a) {
        repository.save(AnswerPostgresEntity.of(a));
        return a;
    }
}
