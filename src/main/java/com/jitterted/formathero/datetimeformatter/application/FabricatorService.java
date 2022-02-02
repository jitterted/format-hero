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

    public void withPatternElement(String patternElement, String patternId) {
        Fabricator fabricator = findBy(patternId)
                                .with(patternElement);
        fabricatorRepository.save(fabricator, patternId);
    }

    public List<String> currentExamples(String patternId) {
        Fabricator fabricator = findBy(patternId);
        return exampleDates.stream()
                           .map(fabricator::formatFor)
                           .toList();
    }

    public String patternFor(String patternId) {
        Fabricator fabricator = findBy(patternId);
        return fabricator.pattern();
    }

    private Fabricator findBy(String patternId) {
        return fabricatorRepository
                .findById(patternId)
                .orElse(Fabricator.EMPTY);
    }
}
