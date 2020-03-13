package io.jgoerner.querygenerator.questions.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionPostgresRepository extends JpaRepository<QuestionPostgresEntity, Long> {
}
