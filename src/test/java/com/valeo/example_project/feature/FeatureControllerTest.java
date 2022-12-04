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
class FeatureControllerTest {

    @Mock
    FeatureService serviceMock;

    @InjectMocks
    FeatureController controller;

    @Test
    void GetAllFeatures_WhenCalled_ReturnsListOfFeaturesFromService() {

        // Given
        List<Feature> expectedFeatures = new ArrayList<>();
        expectedFeatures.add(new Feature(1, "test feature 1"));
        expectedFeatures.add(new Feature(2, "test feature 2"));

        when(serviceMock.getAll()).thenReturn(expectedFeatures);

        // When
        List<Feature> actualFeatures = controller.getAllFeatures();

        // Should
        assertArrayEquals(expectedFeatures.toArray(), actualFeatures.toArray());
    }

    @Test
    void GetFeature_WithValidId_ReturnsFeatureFromService() {

        // Given
        Feature expectedFeature = new Feature(1, "test feature 1");
        when(serviceMock.getOne(1)).thenReturn(expectedFeature);

        // When
        Feature actualFeature = controller.getFeature(1);

        // Should
        assertEquals(expectedFeature, actualFeature);
    }
}