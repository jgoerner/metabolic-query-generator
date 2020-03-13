package io.jgoerner.querygenerator.questions.application.service;

import io.jgoerner.querygenerator.questions.application.port.in.AnswerQueryCorrectUseCase;
import io.jgoerner.querygenerator.questions.application.port.in.AnswerQueryWrongUseCase;
import io.jgoerner.querygenerator.questions.application.port.out.SaveAnswerPort;
import io.jgoerner.querygenerator.questions.domain.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerService implements AnswerQueryCorrectUseCase, AnswerQueryWrongUseCase {

    private final SaveAnswerPort saveAnswerPort;

    @Override
    public Answer createCorrect(String qid) {
        var answer =  Answer.correct().qid(qid).build();
        saveAnswerPort.save(answer);
        return answer;
    }

    @Override
    public Answer createWrong(String qid) {
        var answer =  Answer.wrong().qid(qid).build();
        saveAnswerPort.save(answer);
        return answer;
    }
}
