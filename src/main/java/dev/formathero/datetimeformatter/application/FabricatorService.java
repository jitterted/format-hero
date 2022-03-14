package dev.formathero.datetimeformatter.application;

import dev.formathero.datetimeformatter.application.port.FabricatorRepository;
import dev.formathero.datetimeformatter.domain.Fabricator;

import java.time.ZonedDateTime;
import java.util.List;

public class FabricatorService {

    private final List<ZonedDateTime> exampleDates;
    private final FabricatorRepository fabricatorRepository;

   public FabricatorService(FabricatorRepository fabricatorRepository,
                             List<ZonedDateTime> exampleDates) {
        this.exampleDates = exampleDates;
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
