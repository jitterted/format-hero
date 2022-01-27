package com.jitterted.datetimeformatter.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Fabricator {
    private final List<String> fragments = new ArrayList<>();

    public Fabricator with(String fragment) {
        fragments.add(fragment);
        return this;
    }

    public String pattern() {
        return String.join("-", fragments);
    }

    public String formatFor(ZonedDateTime zoneDateTimeUtc) {
        return DateTimeFormatter.ofPattern(pattern())
                                .format(zoneDateTimeUtc);
    }
}
