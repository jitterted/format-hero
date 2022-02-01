package com.jitterted.formathero.datetimeformatter.application.port;

import com.jitterted.formathero.datetimeformatter.domain.Fabricator;

import java.util.Optional;

public interface FabricatorRepository {

    Optional<Fabricator> findById(String id);

    void save(Fabricator fabricator, String id);
}
