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
        Fabricator fabricator = new Fabricator().with("yyyy");

        ZonedDateTime jan9_2022 = ZonedDateTimeFactory.zoneDateTimeUtc(2022, 1, 9);
        assertThat(fabricator.formatFor(jan9_2022))
                .isEqualTo("2022");
    }

    @Test
    public void givenYearPatternAddDayFragmentResultsInYearDayPattern() throws Exception {
        Fabricator fabricator = new Fabricator().with("yyyy");

        fabricator = fabricator.with("dd");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-dd");
    }

    @Test
    public void given_yyyy_and_M_FragmentAdd_dd_FragmentThenPatternHasAllFragments() throws Exception {
        Fabricator fabricator = new Fabricator()
                .with("yyyy")
                .with("M");

        fabricator = fabricator.with("dd");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-M-dd");
    }

    @Test
    public void fabricatorIsImmutable() throws Exception {
        Fabricator yyyy_fabricator = new Fabricator().with("yyyy");

        Fabricator mm_fabricator = yyyy_fabricator.with("MM");

        assertThat(yyyy_fabricator)
                .isNotEqualTo(mm_fabricator);
    }
}
