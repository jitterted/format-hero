package com.jitterted.formathero.datetimeformatter.domain;

import com.jitterted.formathero.datetimeformatter.SomeZonedDateTimes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PatternFabricatorTest {

    @Test
    public void newFabricatorHasEmptyPattern() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY;

        assertThat(fabricator.pattern())
                .isEmpty();
    }

    @Test
    public void newFabricatorHasEmptyExample() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY;

        assertThat(fabricator.formatFor(SomeZonedDateTimes.JAN_3_2022))
                .isEmpty();
    }

    @Test
    public void newFabricator4DigitYearResultsIn4DigitYearPattern() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY;

        Fabricator yyyy = fabricator.with("yyyy");

        assertThat(yyyy.pattern())
                .isEqualTo("yyyy");
    }

    @Test
    public void fabricatorWithYearPatternResultsInFormattedDateOfJustYear() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY.with("yyyy");

        assertThat(fabricator.formatFor(SomeZonedDateTimes.NOV_25_2024))
                .isEqualTo("2024");
    }

    @Test
    public void givenYearPatternAddDayFragmentResultsInYearDayPattern() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY.with("yyyy");

        fabricator = fabricator.with("dd");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-dd");
    }

    @Test
    public void given_yyyy_and_M_FragmentAdd_dd_FragmentThenPatternHasAllFragments() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY
                .with("yyyy")
                .with("M");

        fabricator = fabricator.with("dd");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-M-dd");
    }

    @Test
    public void fabricatorIsImmutable() throws Exception {
        Fabricator yyyy_fabricator = Fabricator.EMPTY.with("yyyy");

        Fabricator mm_fabricator = yyyy_fabricator.with("MM");

        assertThat(yyyy_fabricator)
                .isNotEqualTo(mm_fabricator);
    }

    @Test
    public void whenAddedYearDayMonthThenOrderIsYearMonthDay() throws Exception {
        // ASSUMES DEFAULT ORDER: Year, Month, Day
        Fabricator fabricator = Fabricator.EMPTY.with("yy")
                                                .with("dd");

        fabricator = fabricator.with("M");

        assertThat(fabricator.pattern())
                .isEqualTo("yy-M-dd");
    }

    @Test
    public void whenMonthExistsThenWithNewMonthReplacesOldMonthPattern() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY.with("yyyy")
                                                .with("M")
                                                .with("dd");

        fabricator = fabricator.with("MM");

        assertThat(fabricator.pattern())
                .isEqualTo("yyyy-MM-dd");
    }

    @Test
    public void unknownPatternElementThrowsException() throws Exception {
        Fabricator fabricator = Fabricator.EMPTY;

        assertThatThrownBy(() -> fabricator.with("xyz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Did not understand the Pattern Element 'xyz'");
    }
}
