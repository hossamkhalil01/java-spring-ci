package com.valeo.example_project.commons.helpers;

import java.security.InvalidParameterException;
import java.util.Date;

/**
 * Validator helper class used validate request params.
 *
 * @author Hossam Khalil
 */
public abstract class Validators {

    /**
     * Checks if the date is in a valid range (not after the current date).
     *
     * @param date: the date value.
     * @throws InvalidParameterException: if the date is invalid range.
     */
    public static void validateDate(Date date) {
        if (date.after(new Date())) throw new InvalidParameterException("Invalid date, date is out of range.");
    }

    /**
     * Checks if the parameter exists.
     *
     * @param object:        the object to be validated.
     * @param parameterName: the parameter field name for the validation error message.
     * @throws InvalidParameterException: upon failing to retrieve value form the object.
     */
    public static void validateRequiredParameter(Object object, String parameterName) {
        if (object != null) return;
        throw new InvalidParameterException(parameterName + " is missing; " + parameterName + " cannot be null.");
    }
}
