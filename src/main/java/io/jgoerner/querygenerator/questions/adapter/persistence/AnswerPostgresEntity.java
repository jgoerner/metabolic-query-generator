package io.jgoerner.querygenerator.questions.adapter.persistence;

import io.jgoerner.querygenerator.questions.domain.Answer;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Setter
@Table(name="ANSWERS")
public class AnswerPostgresEntity {

    @Id String aid;
    LocalDateTime created;
    String qid;
    String result;

    static AnswerPostgresEntity of(Answer a) {
        var ape = new AnswerPostgresEntity();
        ape.setAid(a.getAid());
        ape.setCreated(a.getCreated());
        ape.setQid(a.getQid());
        ape.setResult(a.getResult().toString());
        return ape;
    }
}
