package com.jitterted.datetimeformatter.domain;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;

public class PatternFabricatorTest {
    @Test
    public void newFabricator4DigitYearResultsIn4DigitYearPattern() throws Exception {
        Fabricator fabricator = new Fabricator();

        Fabricator yyyy = fabricator.with("yyyy");

        assertThat(yyyy.pattern())
                .isEqualTo("yyyy");
    }

    @Test
    public void fabricatorWithYearPatternResultsInFormattedDateOfJustYear() throws Exception {
        Fabricator fabricator = new Fabricator();
        fabricator = fabricator.with("yyyy");

        ZonedDateTime jan9_2022 = ZonedDateTimeFactory.zoneDateTimeUtc(2022, 1, 9);
        assertThat(fabricator.formatFor(jan9_2022))
                .isEqualTo("2022");
    }
}
