package io.jgoerner.querygenerator.questions.application.port.out;

import io.jgoerner.querygenerator.questions.domain.Question;

public interface SaveQuestionPort {

    Question save(Question q);
}
