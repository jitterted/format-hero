package com.jitterted.datetimeformatter.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Fabricator {
    private final Map<Integer, String> fragments = new TreeMap<>();

    public Fabricator() {
    }

    private Fabricator(Map<Integer, String> fragments, String fragment) {
        this.fragments.putAll(fragments);
        this.fragments.put(fragments.size() + 1, fragment);
    }

    public Fabricator with(String fragment) {
        return new Fabricator(fragments, fragment);
    }

    public String pattern() {
        return String.join("-", fragments.values());
    }

    public String formatFor(ZonedDateTime zoneDateTimeUtc) {
        return DateTimeFormatter.ofPattern(pattern())
                                .format(zoneDateTimeUtc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fabricator that = (Fabricator) o;

        return fragments.equals(that.fragments);
    }

    @Override
    public int hashCode() {
        return fragments.hashCode();
    }
}
