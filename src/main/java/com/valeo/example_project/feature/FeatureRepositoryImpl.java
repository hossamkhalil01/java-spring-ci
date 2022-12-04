package com.valeo.example_project.feature;

import com.valeo.example_project.commons.api.ResourceNotFoundException;
import com.valeo.example_project.commons.logging.Loggable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation for the feature repository
 *
 * @author Hossam Khalil
 */
@Repository
public class FeatureRepositoryImpl implements FeatureRepository {

    // example in memory data
    private static final List<Feature> features = new ArrayList<>();

    static {
        features.add(new Feature(1, "new feature 1"));
        features.add(new Feature(2, "new feature 2"));
        features.add(new Feature(3, "new feature 3"));
    }

    /**
     * Returns list of the features available or empty list if none was found.
     *
     * @return list of features.
     */
    @Override
    @Loggable
    public List<Feature> getAll() {
        return new ArrayList<>(features);
    }

    /**
     * Gets a feature by ID.
     *
     * @return the feature if found.
     * @throws ResourceNotFoundException if the feature doesn't exist.
     */
    @Override
    @Loggable
    public Feature getOne(int id) {
        for (Feature feature : features) {
            if (feature.getId() == id) {
                return feature;
            }
        }
        throw new ResourceNotFoundException("Feature", String.valueOf(id));
    }
}
