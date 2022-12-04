package com.valeo.example_project.commons.api;

/**
 * Represents a template for all resources not found exceptions.
 *
 * @author Hossam Khalil
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final String MSG_TEMPLATE = "%s with id <%s> is not found";

    public ResourceNotFoundException(String resourceName, String id) {
        super( String.format(MSG_TEMPLATE, resourceName, id));
    }
}
