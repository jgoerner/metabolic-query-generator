package io.jgoerner.querygenerator.data.adapter.persistence;

import io.jgoerner.querygenerator.data.domain.Enzyme;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="Enzyme")
@NoArgsConstructor
@AllArgsConstructor
public class EnzymeNeoEntity {

    @Id private  String name;
    private String abbreviation;

    static EnzymeNeoEntity of(Enzyme e) {
        return new EnzymeNeoEntity(
                e.getName(),
                e.getAbbreviation()
        );
    }
}
