package io.jgoerner.querygenerator.questions.application.port.out;

import io.jgoerner.querygenerator.questions.domain.Candidate;

public interface FindNameToAbbreviationCandidatePort {

    Candidate findNameToAbbreviationCandidate();;
}
