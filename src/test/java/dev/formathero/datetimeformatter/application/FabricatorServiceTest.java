package dev.formathero.datetimeformatter.application;

import dev.formathero.datetimeformatter.SomeZonedDateTimes;
import dev.formathero.datetimeformatter.application.port.FabricatorRepository;
import dev.formathero.datetimeformatter.domain.Fabricator;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FabricatorServiceTest {

    @Test
    void withValidPatternAndOneExampleDateReturnsOnlyOneExample() throws Exception {
        FabricatorService fabricatorService = new FabricatorService(
                new InMemoryFabricatorRepository(), List.of(SomeZonedDateTimes.OCT_9_2023));

        fabricatorService.withPatternElement("yyyy", "valid-pattern-23");

        assertThat(fabricatorService.currentExamples("valid-pattern-23"))
                .containsOnly("2023");
    }

    @Test
    void withValidPatternAnd3ExampleDatesReturns3Examples() throws Exception {
        List<ZonedDateTime> exampleDates = List.of(
                SomeZonedDateTimes.JAN_3_2022,
                SomeZonedDateTimes.OCT_9_2023,
                SomeZonedDateTimes.NOV_25_2024
        );
        FabricatorService fabricatorService = new FabricatorService(
                new InMemoryFabricatorRepository(), exampleDates);

        fabricatorService.withPatternElement("yyyy", "three-examples");

        assertThat(fabricatorService.currentExamples("three-examples"))
                .containsOnly("2022", "2023", "2024");
    }

    @Test
    void patternIsReturnedForId() throws Exception {
        FabricatorRepository fabricatorRepository = new InMemoryFabricatorRepository();
        String coldPenguinId = "cold-penguin-23";
        Fabricator fabricator = Fabricator.EMPTY.with("yyyy").with("MM");
        fabricatorRepository.save(fabricator, coldPenguinId);
        FabricatorService fabricatorService = new FabricatorService(
                fabricatorRepository,
                List.of(SomeZonedDateTimes.JAN_9_2031));

        String pattern = fabricatorService.patternFor(coldPenguinId);

        assertThat(pattern)
                .isEqualTo("yyyy-MM");
    }

}