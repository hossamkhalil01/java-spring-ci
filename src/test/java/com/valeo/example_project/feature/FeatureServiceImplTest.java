package com.valeo.example_project.feature;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FeatureServiceImplTest {

    @Mock
    FeatureRepository repoMock;

    @InjectMocks
    FeatureServiceImpl service;

    @Test
    void GetAll_WithSuccess_ReturnsListOfFeatures() {

        // Given
        List<Feature> expectedFeatures = new ArrayList<>();
        expectedFeatures.add(new Feature(1, "test feature 1"));
        expectedFeatures.add(new Feature(2, "test feature 2"));

        when(repoMock.getAll()).thenReturn(expectedFeatures);

        // When
        List<Feature> actualFeatures = service.getAll();

        // Should
        assertEquals(2, actualFeatures.size());
        assertArrayEquals(expectedFeatures.toArray(), actualFeatures.toArray());

    }

    @Test
    void GetOne_WithValidId_ReturnsFeature() {

        // Given
        Feature expectedFeature = new Feature(1, "test feature 1");
        when(repoMock.getOne(1)).thenReturn(expectedFeature);

        // When
        Feature actualFeature = service.getOne(1);

        // Should
        assertEquals(expectedFeature, actualFeature);
    }
}