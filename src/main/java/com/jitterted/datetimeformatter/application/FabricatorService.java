package com.jitterted.datetimeformatter.application;

import com.jitterted.datetimeformatter.domain.Fabricator;

import java.time.ZonedDateTime;

public class FabricatorService {

    private final ZonedDateTime exampleDate;

    private Fabricator fabricator = new Fabricator();

    public FabricatorService(ZonedDateTime exampleDate) {
        this.exampleDate = exampleDate;
    }

    public String currentPattern() {
        return fabricator.pattern();
    }

    public void withPatternElement(String patternElement) {
        fabricator = fabricator.with(patternElement);
    }

    public String currentExample() {
        return fabricator.formatFor(exampleDate);
    }
}
