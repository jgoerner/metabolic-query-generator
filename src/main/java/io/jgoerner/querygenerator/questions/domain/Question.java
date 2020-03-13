package io.jgoerner.querygenerator.questions.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Value
public class Question {
    String qid;
    LocalDateTime created;
    String question;
    String answer;

    public static QuestionBuilder standard() {
        return Question.builder()
                .qid(UUID.randomUUID().toString())
                .created(LocalDateTime.now());
    }
}
