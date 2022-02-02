package com.jitterted.formathero.datetimeformatter.adapter.out.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.jitterted.formathero.datetimeformatter.application.port.FabricatorRepository;
import com.jitterted.formathero.datetimeformatter.domain.Fabricator;

import java.util.Optional;

public class CaffeineFabricatorRepository implements FabricatorRepository {
    private final Cache<String, Fabricator> cache =
            Caffeine.newBuilder()
                    .maximumSize(10_000)
                    .build();

    @Override
    public Optional<Fabricator> findById(String id) {
        return Optional.ofNullable(cache.getIfPresent(id));
    }

    @Override
    public void save(Fabricator fabricator, String id) {
        cache.put(id, fabricator);
    }
}
