package io.jgoerner.querygenerator.questions.application.service;

import io.jgoerner.querygenerator.questions.application.port.in.AbbreviationToNameUseCase;
import io.jgoerner.querygenerator.questions.application.port.in.NameToAbbreviationUseCase;
import io.jgoerner.querygenerator.questions.application.port.out.FindAbbreviationToNameCandidatePort;
import io.jgoerner.querygenerator.questions.application.port.out.FindNameToAbbreviationCandidatePort;
import io.jgoerner.querygenerator.questions.application.port.out.SaveQuestionPort;
import io.jgoerner.querygenerator.questions.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionService implements AbbreviationToNameUseCase, NameToAbbreviationUseCase {

    private final SaveQuestionPort saveQuestionPort;
    private final FindAbbreviationToNameCandidatePort findAbbreviationToNameCandidatePort;
    private final FindNameToAbbreviationCandidatePort findNameToAbbreviationCandidatePort;

    @Override
    public Question askAbbreviationToNameQuery() {

        var candidate = findAbbreviationToNameCandidatePort.findAbbreviationToNameCandidate();

        var q = Question.standard()
                .question("What does " + candidate.getQuestionFragment() + " stand for?")
                .answer(candidate.getAnswerFragment()).build();
        saveQuestionPort.save(q);

        return q;
    }

    @Override
    public Question askNameToAbbreviationQuery() {
        var candidate = findNameToAbbreviationCandidatePort.findNameToAbbreviationCandidate();

        var q = Question.standard()
                .question("What is the abbreviation for  " + candidate.getQuestionFragment() + "?")
                .answer(candidate.getAnswerFragment())
                .build();
        saveQuestionPort.save(q);

        return q;    }
}
