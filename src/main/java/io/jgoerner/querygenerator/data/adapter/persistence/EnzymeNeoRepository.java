package io.jgoerner.querygenerator.data.adapter.persistence;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EnzymeNeoRepository extends Neo4jRepository<EnzymeNeoEntity, String> {
}
