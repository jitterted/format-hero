package com.jitterted.datetimeformatter.application;

import com.jitterted.datetimeformatter.SomeZonedDateTimes;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FabricatorServiceTest {

    @Test
    public void withValidPatternAndOneExampleDateReturnsOnlyOneExample() throws Exception {
        FabricatorService fabricatorService = new FabricatorService(
                List.of(SomeZonedDateTimes.OCT_9_2023));

        fabricatorService.withPatternElement("yyyy");

        assertThat(fabricatorService.currentExamples())
                .containsOnly("2023");
    }

    @Test
    public void withValidPatternAnd3ExampleDatesReturns3Examples() throws Exception {
        List<ZonedDateTime> exampleDates = List.of(
                SomeZonedDateTimes.JAN_3_2022,
                SomeZonedDateTimes.OCT_9_2023,
                SomeZonedDateTimes.NOV_25_2024
        );
        FabricatorService fabricatorService = new FabricatorService(
                exampleDates);

        fabricatorService.withPatternElement("yyyy");

        assertThat(fabricatorService.currentExamples())
                .containsOnly("2022", "2023", "2024");
    }

}