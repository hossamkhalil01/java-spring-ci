package com.valeo.example_project.commons.helpers;

import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateHelpersTest {


    @Test
    void testParseDateWithSupportedDateFormat() {
        /* Tests that the function returns the date if the format is supported date format */

        Date parsedDate = DateHelpers.parseDate("5-10-2020");

        assertEquals(5, DateUtil.dayOfMonthOf(parsedDate));
        assertEquals(10, DateUtil.monthOf(parsedDate));
        assertEquals(2020, DateUtil.yearOf(parsedDate));
        assertEquals(0, DateUtil.hourOfDayOf(parsedDate));
        assertEquals(0, DateUtil.minuteOf(parsedDate));
        assertEquals(0, DateUtil.secondOf(parsedDate));
    }

    @Test
    void testParseDateWithSupportedDateTimeFormat() {
        /* Tests that the function returns the date if the format is supported datetime format */

        Date parsedDate = DateHelpers.parseDate("11-03-2019T11:36:02");

        assertEquals(11, DateUtil.dayOfMonthOf(parsedDate));
        assertEquals(3, DateUtil.monthOf(parsedDate));
        assertEquals(2019, DateUtil.yearOf(parsedDate));
        assertEquals(11, DateUtil.hourOfDayOf(parsedDate));
        assertEquals(36, DateUtil.minuteOf(parsedDate));
        assertEquals(2, DateUtil.secondOf(parsedDate));
    }


    @Test
    void testThrowsParseUnSupportedFormat() {
        /* Tests that the function throws if the format is not supported */

        Exception e = assertThrows(DateTimeParseException.class, () -> {
            DateHelpers.parseDate("11/03/2019");
        });
        assertTrue(e.getMessage().contains("expected patterns: " + Arrays.toString(DateHelpers.getSupportedFormats().toArray())));
    }

    @Test
    void testThrowsParseExceptionIfMonthIsMoreThan12() {
        /* Tests that the function throws if the date has a month value more than 12 */

        Exception e = assertThrows(DateTimeParseException.class, () -> DateHelpers.parseDate("11-20-2019"));
        assertTrue(e.getMessage().contains("expected patterns: " + Arrays.toString(DateHelpers.getSupportedFormats().toArray())));
    }

    @Test
    void testThrowsParseExceptionIfMonthIsMoreThan12InDateTime() {
        /* Tests that the function throws if the date has a month value more than 12 */

        Exception e = assertThrows(DateTimeParseException.class, () -> DateHelpers.parseDate("11-20-2019T12-30-05"));
        assertTrue(e.getMessage().contains("expected patterns: " + Arrays.toString(DateHelpers.getSupportedFormats().toArray())));
    }
}