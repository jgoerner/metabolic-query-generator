package io.jgoerner.querygenerator.data.adapter.persistence;

import io.jgoerner.querygenerator.data.domain.Intermediate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="Intermediate")
@NoArgsConstructor
@AllArgsConstructor
public class IntermediateNeoEntity {

    @Id private String name;
    private String abbreviation;

    static IntermediateNeoEntity of(Intermediate i){
        return new IntermediateNeoEntity(
                i.getName(),
                i.getAbbreviation()
        );
    }
}
