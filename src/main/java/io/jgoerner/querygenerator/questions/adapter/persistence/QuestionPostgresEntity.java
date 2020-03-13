package io.jgoerner.querygenerator.questions.adapter.persistence;

import io.jgoerner.querygenerator.questions.domain.Question;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Setter
@Table(name="QUESTIONS")
public class QuestionPostgresEntity {

    @Id String qid;
    String question;
    String answer;
    LocalDateTime created;

    static QuestionPostgresEntity of(Question q) {
        var qpe = new QuestionPostgresEntity();
        qpe.setQid(q.getQid());
        qpe.setCreated(q.getCreated());
        qpe.setQuestion(q.getQuestion());
        qpe.setAnswer(q.getAnswer());
        return qpe;
    }
}

