package com.jitterted.datetimeformatter.application;

import com.jitterted.datetimeformatter.domain.Fabricator;

public class FabricatorService {

    private Fabricator fabricator = new Fabricator();

    public String currentPattern() {
        return fabricator.pattern();
    }

    public void withPatternElement(String patternElement) {
        fabricator = fabricator.with(patternElement);
    }
}
