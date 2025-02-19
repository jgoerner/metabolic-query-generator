package io.jgoerner.querygenerator.questions.adapter.persistence;

import io.jgoerner.querygenerator.questions.application.port.out.FindAbbreviationToNameCandidatePort;
import io.jgoerner.querygenerator.questions.application.port.out.FindNameToAbbreviationCandidatePort;
import io.jgoerner.querygenerator.questions.domain.Candidate;
import lombok.extern.log4j.Log4j2;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class CandidatePort implements FindAbbreviationToNameCandidatePort, FindNameToAbbreviationCandidatePort {

    @Value("${spring.data.neo4j.username}")
    private String username;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Value("${spring.data.neo4j.uri}")
    private String uri;

    private  Driver driver;

    @PostConstruct
    void init() {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(this.username, this.password));
    }

    @Override
    public Candidate findAbbreviationToNameCandidate() {
        Candidate candidate;
        try (var session = driver.session()) {
            var result = session.run("MATCH (n) " +
                    "WITH n, rand() AS r " +
                    "WHERE n.name IS NOT NULL " +
                    "AND n.abbreviation IS NOT NULL " +
                    "RETURN n.name as name, n.abbreviation as abbreviation " +
                    "ORDER by r " +
                    "LIMIT 1").single();
            candidate = new Candidate(result.get("abbreviation").toString(), result.get("name").asString());
            log.info("Found candidate:" + candidate);
        }
        return candidate;
    }

    @Override
    public Candidate findNameToAbbreviationCandidate() {
        Candidate candidate;
        try (var session = driver.session()) {
            var result = session.run("MATCH (n) " +
                    "WITH n, rand() AS r " +
                    "WHERE n.name IS NOT NULL " +
                    "AND n.abbreviation IS NOT NULL " +
                    "RETURN n.name as name, n.abbreviation as abbreviation " +
                    "ORDER by r " +
                    "LIMIT 1").single();
            candidate = new Candidate(result.get("name").toString(), result.get("abbreviation").asString());
            log.info("Found candidate:" + candidate);
        }
        return candidate;
    }
}
