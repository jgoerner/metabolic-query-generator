package io.jgoerner.querygenerator.questions.application.port.out;

import io.jgoerner.querygenerator.questions.domain.Answer;

public interface SaveAnswerPort {

    Answer save(Answer a);
}
