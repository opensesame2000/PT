package com.powertamil.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Date-time String formatter utility class.
 */
public class DateFormatter {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME
            .withZone(ZoneId.systemDefault());

    /**
     * @return a String representing the current datetime
     */
    public static String now() {
        return format(Instant.now());
    }

    /**
     * @return a String representing a particular timestamp (in milliseconds)
     */
    public static String format(long timestamp) {
        return format(Instant.ofEpochMilli(timestamp));
    }

    /**
     * @return a String representing a particular time instant
     */
    public static String format(Instant instant) {
        return DATE_FORMAT.format(instant);
    }

    /**
     * @param datetime
     * @return the parsed timestamp (in milliseconds) of the provided datetime
     * @throws DateTimeParseException
     */
    public static long parse(String datetime) throws DateTimeParseException {
        Instant instant = Instant.from(DATE_FORMAT.parse(datetime));

        return instant.toEpochMilli();
    }

    private DateFormatter() {
    }
}
