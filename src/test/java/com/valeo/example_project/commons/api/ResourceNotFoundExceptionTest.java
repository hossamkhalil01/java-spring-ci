package com.valeo.example_project.commons.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    @Test
    void Constructor_WithResourceNameAndId_IncludesValuesInExceptionMessage(){

        // Given
        String id = "1234";
        String resourceName = "TableInfo";

        // When
        Exception e = new ResourceNotFoundException(resourceName,id);

        // Should
        assertTrue(e.getMessage().contains("TableInfo"));
        assertTrue(e.getMessage().contains("1234"));
    }

    @Test
    void Constructor_WithResourceNameIdAndInfo_ConstructsDescriptiveMessage(){

        // Given
        String id = "1234";
        String resourceName = "TableInfo";

        // When
        Exception e = new ResourceNotFoundException(resourceName,id);

        // Should
        assertEquals("TableInfo with id <1234> is not found",
                e.getMessage());
    }
}