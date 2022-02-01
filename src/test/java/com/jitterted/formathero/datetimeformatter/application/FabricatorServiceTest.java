package com.jitterted.formathero.datetimeformatter.application;

import com.jitterted.formathero.datetimeformatter.SomeZonedDateTimes;
import com.jitterted.formathero.datetimeformatter.application.port.FabricatorRepository;
import com.jitterted.formathero.datetimeformatter.domain.Fabricator;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void patternIsReturnedForId() throws Exception {
        FabricatorRepository fabricatorRepository = new FabricatorRepository() {
            public Optional<Fabricator> findById(String id) {
                return Optional.ofNullable(new Fabricator().with("yyyy").with("MM"));
            }

            public void save(Fabricator fabricator, String id) {
            }
        };
        FabricatorService fabricatorService = new FabricatorService(
                fabricatorRepository,
                SomeZonedDateTimes.JAN_9_2031);

        String pattern = fabricatorService.currentPattern(); // cold-penguin-23

        assertThat(pattern)
                .isEqualTo("yyyy-MM");
    }

}