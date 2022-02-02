package com.jitterted.formathero.datetimeformatter.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Fabricator {
    private final Map<Integer, String> fragments = new TreeMap<>();

    public static final Fabricator EMPTY = new Fabricator();

    private Fabricator() {
    }

    private Fabricator(Map<Integer, String> fragments, String fragment) {
        this.fragments.putAll(fragments);
        int index = switch (fragment) {
            case "yy", "yyyy" -> 0;
            case "M", "MM" -> 1;
            case "d", "dd" -> 2;
            default -> throw new IllegalArgumentException("Did not understand the Pattern Element '" + fragment + "'");
        };
        this.fragments.put(index, fragment);
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
