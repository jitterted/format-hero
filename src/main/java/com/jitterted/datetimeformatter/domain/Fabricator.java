package com.jitterted.datetimeformatter.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Fabricator {
    private final List<String> fragments = new ArrayList<>();

    public Fabricator() {
    }

    private Fabricator(List<String> fragments, String fragment) {
        this.fragments.addAll(fragments);
        this.fragments.add(fragment);
    }

    public Fabricator with(String fragment) {
        return new Fabricator(fragments, fragment);
    }

    public String pattern() {
        return String.join("-", fragments);
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
