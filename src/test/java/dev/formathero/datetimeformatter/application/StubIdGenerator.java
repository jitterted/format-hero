package dev.formathero.datetimeformatter.application;

import dev.formathero.datetimeformatter.application.port.IdGenerator;

public class StubIdGenerator implements IdGenerator {
    @Override
    public String newId() {
        return "windy-dolphin-73";
    }
}
