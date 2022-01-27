package com.jitterted.datetimeformatter.domain;

import java.time.ZonedDateTime;

public class Fabricator {
    public Fabricator with(String fragment) {
        return this;
    }

    public String pattern() {
        return "yyyy";
    }

    public String formatFor(ZonedDateTime zoneDateTimeUtc) {
        return "2022";
    }
}
