package com.valeo.example_project.feature;

import com.valeo.example_project.commons.api.ResourceNotFoundException;
import com.valeo.example_project.commons.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles the functionalities regarding the feature entity.
 *
 * @author Hossam Khalil
 */
@Service
public class FeatureServiceImpl implements FeatureService {


    @Autowired
    private FeatureRepository repository;

    /**
     * Fetches all the configs.
     *
     * @return a list of Features.
     */
    @Override
    @Loggable
    public List<Feature> getAll() {
        return repository.getAll();
    }

    /**
     * Fetches the feature with a given id.
     *
     * @param id: target feature id.
     * @return the feature object.
     * @throws ResourceNotFoundException: if the feature does not exist.
     */
    @Override
    @Loggable
    public Feature getOne(int id) {
        return repository.getOne(id);
    }
}
