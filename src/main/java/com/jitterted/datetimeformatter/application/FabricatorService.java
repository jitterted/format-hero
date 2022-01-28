package com.jitterted.datetimeformatter.application;

import com.jitterted.datetimeformatter.domain.Fabricator;

import java.time.ZonedDateTime;
import java.util.List;

public class FabricatorService {

    private final List<ZonedDateTime> exampleDates;

    private Fabricator fabricator = new Fabricator();

    public FabricatorService(ZonedDateTime exampleDate) {
        this.exampleDates = List.of(exampleDate);
    }

    public String currentPattern() {
        return fabricator.pattern();
    }

    public void withPatternElement(String patternElement) {
        fabricator = fabricator.with(patternElement);
    }

    public List<String> currentExamples() {
        return exampleDates.stream()
                           .map(exampleDate ->
                                        fabricator.formatFor(exampleDate))
                           .toList();
    }
}
