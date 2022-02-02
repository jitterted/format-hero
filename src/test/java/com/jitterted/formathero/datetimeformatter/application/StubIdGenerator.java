package com.jitterted.formathero.datetimeformatter.application;

import com.jitterted.formathero.datetimeformatter.application.port.IdGenerator;

public class StubIdGenerator implements IdGenerator {
    @Override
    public String newId() {
        return "windy-dolphin-73";
    }
}
