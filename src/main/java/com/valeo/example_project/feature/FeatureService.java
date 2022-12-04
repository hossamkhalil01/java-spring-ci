package com.valeo.example_project.feature;

import java.util.List;

/**
 * Provides the needed functionalities for feature service
 *
 * @author Hossam Khalil
 */
public interface FeatureService {

    /**
     * Fetches all the configs.
     *
     * @return a list of Features.
     */
    List<Feature> getAll();

    /**
     * Fetches the feature for with a given feature id.
     *
     * @param id: the target feature id.
     * @return the feature object.
     * @throws com.valeo.example_project.commons.api.ResourceNotFoundException: if the feature doesn't exist.
     */
    Feature getOne(int id);

}
