package com.jitterted.datetimeformatter.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Fabricator {
    private String pattern;

    public Fabricator with(String fragment) {
        if (pattern == null) {
            pattern = fragment;
        } else {
            pattern = pattern + "-" + fragment;
        }
        return this;
    }

    public String pattern() {
        return pattern;
    }

    public String formatFor(ZonedDateTime zoneDateTimeUtc) {
        return DateTimeFormatter.ofPattern(pattern).format(zoneDateTimeUtc);
    }
}
