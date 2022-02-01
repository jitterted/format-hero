package com.jitterted.formathero.datetimeformatter.application;

import com.jitterted.formathero.datetimeformatter.application.port.FabricatorRepository;
import com.jitterted.formathero.datetimeformatter.domain.Fabricator;

import java.time.ZonedDateTime;
import java.util.List;

public class FabricatorService {

    private final List<ZonedDateTime> exampleDates;
    private FabricatorRepository fabricatorRepository
            = new InMemoryFabricatorRepository();

    public FabricatorService(ZonedDateTime exampleDate) {
        this.exampleDates = List.of(exampleDate);
    }

    public FabricatorService(List<ZonedDateTime> exampleDates) {
        this.exampleDates = exampleDates;
    }

    public FabricatorService(FabricatorRepository fabricatorRepository, ZonedDateTime exampleDate) {
        exampleDates = List.of(exampleDate);
        this.fabricatorRepository = fabricatorRepository;
    }

    public String currentPattern() {
        return getFabricator().pattern();
    }

    public void withPatternElement(String patternElement) {
        setFabricator(getFabricator().with(patternElement));
    }

    public List<String> currentExamples() {
        return exampleDates.stream()
                           .map(exampleDate ->
                                        getFabricator().formatFor(exampleDate))
                           .toList();
    }

    private Fabricator getFabricator() {
        return fabricatorRepository.findById("temp")
                .orElseGet(Fabricator::new);
    }

    private void setFabricator(Fabricator fabricator) {
        fabricatorRepository.save(fabricator, "temp");
    }

}
