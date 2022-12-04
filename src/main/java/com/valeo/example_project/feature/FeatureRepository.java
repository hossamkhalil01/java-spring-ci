package com.valeo.example_project.feature;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Feature repository interface that defines the available methods for the repository.
 *
 * @author Hossam Khalil
 */
public interface FeatureRepository {

    /**
     * Get all features from the repository
     *
     * @return list of features dto.
     */
    @Cacheable(cacheNames = "all_features")
    List<Feature> getAll();

    /**
     * Gets a feature by ID.
     *
     * @return the feature if found.
     * @throws com.valeo.example_project.commons.api.ResourceNotFoundException: if the feature doesn't exist.
     */
    @Cacheable(cacheNames = "features", key = "#id")
    Feature getOne(int id);
}
