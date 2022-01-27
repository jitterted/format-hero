package com.jitterted.datetimeformatter.domain;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;

public class PatternFabricatorTest {

    private static final ZonedDateTime JAN_9_2022 = ZonedDateTimeFactory.zoneDateTimeUtc(2022, 1, 9);

    @Test
    public void newFabricatorHasEmptyPattern() throws Exception {
        Fabricator fabricator = new Fabricator();

        assertThat(fabricator.pattern())
                .isEmpty();
    }

    @Test
    public void newFabricatorHasEmptyExample() throws Exception {
        Fabricator fabricator = new Fabricator();

        assertThat(fabricator.formatFor(JAN_9_2022))
                .isEmpty();
    }

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

        assertThat(fabricator.formatFor(JAN_9_2022))
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

    @Test
    public void whenAddedYearDayMonthThenOrderIsYearMonthDay() throws Exception {
        // ASSUMES DEFAULT ORDER: Year, Month, Day
        Fabricator fabricator = new Fabricator().with("yyyy")
                                                .with("dd");

        fabricator = fabricator.with("M");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-M-dd");
    }

    @Test
    public void whenMonthExistsThenWithNewMonthReplacesOldMonthPattern() throws Exception {
        Fabricator fabricator = new Fabricator().with("yyyy")
                                                .with("M")
                                                .with("dd");

        fabricator = fabricator.with("MM");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-MM-dd");
    }
}
