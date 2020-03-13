package io.jgoerner.querygenerator.questions.domain;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Value
public class Answer {
    String aid;
    LocalDateTime created;
    String qid;
    Result result;

    @RequiredArgsConstructor
    public enum Result {
        CORRECT("correct"), WRONG("wrong");

        private final String value;

        @Override
        public String toString() {
            return this.value;
        }
    }

    public static AnswerBuilder standard() {
        return Answer.builder()
                .aid(UUID.randomUUID().toString())
                .created(LocalDateTime.now());
    }

    public static AnswerBuilder correct() {
        return standard().result(Result.CORRECT);
    }

    public static AnswerBuilder wrong() {
        return standard().result(Result.WRONG);
    }
}
