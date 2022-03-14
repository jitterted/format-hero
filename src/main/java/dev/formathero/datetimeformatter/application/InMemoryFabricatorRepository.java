package dev.formathero.datetimeformatter.application;

import dev.formathero.datetimeformatter.application.port.FabricatorRepository;
import dev.formathero.datetimeformatter.domain.Fabricator;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryFabricatorRepository implements FabricatorRepository {

    private final Map<String, Fabricator> map = new ConcurrentHashMap<>();

    @Override
    public Optional<Fabricator> findById(String id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void save(Fabricator fabricator, String id) {
        map.put(id, fabricator);
    }
}
