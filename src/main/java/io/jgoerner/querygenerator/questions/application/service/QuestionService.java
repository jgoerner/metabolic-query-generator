package io.jgoerner.querygenerator.questions.application.service;

import io.jgoerner.querygenerator.questions.application.port.in.AbbreviationToNameUseCase;
import io.jgoerner.querygenerator.questions.application.port.out.SaveQuestionPort;
import io.jgoerner.querygenerator.questions.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionService implements AbbreviationToNameUseCase {

    private final SaveQuestionPort saveQuestionPort;

    @Override
    public Question ask() {
        var q = Question.standard().question("HK").answer("Hexokinase").build();
        saveQuestionPort.save(q);
        return q;
    }
}
