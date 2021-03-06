package dev.formathero.datetimeformatter.adapter.out.humanreadable;

import com.github.kkuegler.HumanReadableIdGenerator;
import com.github.kkuegler.PermutationBasedHumanReadableIdGenerator;
import dev.formathero.datetimeformatter.application.port.IdGenerator;

public class ReadableIdGenerator implements IdGenerator {
    private final HumanReadableIdGenerator idGen = new PermutationBasedHumanReadableIdGenerator();

    @Override
    public String newId() {
        return idGen.generate();
    }
}
