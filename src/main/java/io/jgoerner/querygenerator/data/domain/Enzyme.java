package io.jgoerner.querygenerator.data.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Enzyme {
    private final String name;
    private final String abbreviation;
}
