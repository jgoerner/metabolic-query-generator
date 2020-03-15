package io.jgoerner.querygenerator.questions.adapter.persistence;

import io.jgoerner.querygenerator.questions.application.port.out.SaveQuestionPort;
import io.jgoerner.querygenerator.questions.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionPort implements SaveQuestionPort {

    private final QuestionPostgresRepository questionPostgresRepository;

    @Override
    public Question save(Question q) {
        var qpe = QuestionPostgresEntity.of(q);
        questionPostgresRepository.save(qpe);
        return q;
    }

}
