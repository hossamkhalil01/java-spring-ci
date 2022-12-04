package com.valeo.example_project.commons.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Provide helper functions to handle Dates.
 *
 * @author Hossam Khalil
 */
public abstract class DateHelpers {

    private static final String PARSE_ERROR_MSG = "Invalid date time format, expected patterns: %s";
    private static List<String> supportedFormats = new ArrayList<>();

    static {
            supportedFormats.add("dd-MM-yyyy'T'HH:mm:ssZ");
            supportedFormats.add("dd-MM-yyyy'T'HH:mm:ss");
            supportedFormats.add( "dd-MM-yyyy");
    }

    /**
     * Parses the date using all supported formats.
     *
     * @param date: the string of the date to be parsed.
     * @return Date instance of the parsed string.
     * @throws DateTimeParseException: upon failing to parse the date with all the supported formats.
     */
    public static Date parseDate(String date) {

        Date parsedDate = null;
        SimpleDateFormat formatter;
        for (String format : supportedFormats) {
            try {
                formatter = new SimpleDateFormat(format);
                formatter.setLenient(false);
                parsedDate = formatter.parse(date);
                break;
            } catch (ParseException e) {
            }
        }

        if (parsedDate != null) return parsedDate;
        throw new DateTimeParseException(String.format(PARSE_ERROR_MSG, Arrays.toString(supportedFormats.toArray())), date, 0);
    }

    /**
     * Gets the supported date formats (patterns).
     *
     * @return list of strings representing the supported date formats.
     */
    public static List<String> getSupportedFormats() {
        return supportedFormats;
    }

}
