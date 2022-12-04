package com.valeo.example_project.commons.helpers;

import com.valeo.example_project.commons.helpers.Validators;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorsTest {

    @Test
    void testValidateDateWithInvalidDate() {
        /* Tests that validate date throws upon inserting date after the current time */

        long futureDate = new Date().getTime() + 1000000;

        Date date = new Date(futureDate);

        Exception e = assertThrows(InvalidParameterException.class, () -> {
            Validators.validateDate(date);
        });

        assertTrue(e.getMessage().contains("date is out of range"));
    }

    @Test
    void testValidateDateWithValidDate() {
        /* Tests that validate date doesn't throw upon inserting a valid date */

        long pastDate = new Date().getTime() - 100;

        Date date = new Date(pastDate);

        Validators.validateDate(date);
    }

    @Test
    void testValidateRequiredParameterWithNullParam(){
        /* Tests that the validator throws exception upon receiving null required param */

        Exception e = assertThrows(InvalidParameterException.class,()->{

            Validators.validateRequiredParameter(null,"Name Field");
        });

        assertTrue(e.getMessage().contains("Name Field cannot be null."));
    }
    @Test
    void testValidateRequiredParameterWithValidParam(){
        /* Tests that the validator doesn't throw upon receiving valid required param */

        String name = "test_name";
        Validators.validateRequiredParameter(name,"Name Field");

    }

}