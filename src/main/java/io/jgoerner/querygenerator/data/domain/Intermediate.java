package io.jgoerner.querygenerator.data.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Intermediate {
    private final String name;
    private final String abbreviation;
}
