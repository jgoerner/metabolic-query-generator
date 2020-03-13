package io.jgoerner.querygenerator.questions.application.port.in;

import io.jgoerner.querygenerator.questions.domain.Answer;

public interface AnswerQueryWrongUseCase {

    Answer createWrong(String qid);
}
