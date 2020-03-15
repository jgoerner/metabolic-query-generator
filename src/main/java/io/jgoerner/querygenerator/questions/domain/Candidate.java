package io.jgoerner.querygenerator.questions.domain;

import lombok.Value;

@Value
public class Candidate {
    String questionFragment;
    String answerFragment;
}
