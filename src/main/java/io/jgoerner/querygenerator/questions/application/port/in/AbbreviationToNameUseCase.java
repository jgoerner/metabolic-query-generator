package io.jgoerner.querygenerator.questions.application.port.in;

import io.jgoerner.querygenerator.questions.domain.Question;

public interface AbbreviationToNameUseCase {

    Question askAbbreviationToNameQuery();
}