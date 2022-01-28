package com.jitterted.datetimeformatter;

import com.jitterted.datetimeformatter.domain.ZonedDateTimeFactory;

import java.time.ZonedDateTime;

public class SomeZonedDateTimes {
    public static final ZonedDateTime JAN_3_2022 = ZonedDateTimeFactory.zoneDateTimeUtc(2022, 1, 3);
    public static final ZonedDateTime OCT_9_2023 = ZonedDateTimeFactory.zoneDateTimeUtc(2023, 10, 9);
    public static final ZonedDateTime NOV_25_2024 = ZonedDateTimeFactory.zoneDateTimeUtc(2024, 10, 9);
}
