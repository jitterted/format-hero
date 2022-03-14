package dev.formathero.datetimeformatter.domain;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedDateTimeFactory {
    public static ZonedDateTime zoneDateTimeUtc(int year, int month, int dayOfMonth) {
        return ZonedDateTime.of(year, month, dayOfMonth, 0, 0, 0, 0, ZoneOffset.UTC);
    }
}
