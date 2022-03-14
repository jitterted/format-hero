package dev.formathero.datetimeformatter.application.port;

import dev.formathero.datetimeformatter.domain.Fabricator;

import java.util.Optional;

public interface FabricatorRepository {

    Optional<Fabricator> findById(String id);

    void save(Fabricator fabricator, String id);
}
