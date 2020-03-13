package io.jgoerner.querygenerator.data.adapter.persistence;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IntermediateNeoRepository extends Neo4jRepository<IntermediateNeoEntity, String> {
}
