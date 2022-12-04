package com.valeo.example_project.commons.api;

import lombok.Data;

import java.util.Date;

/**
 * Represents a template for all api error responses.
 *
 * @author Hossam Khalil.
 */

@Data
public class ErrorResponse {

    private final Date timestamp;
    private final String message;
    private final String details;

    public ErrorResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
