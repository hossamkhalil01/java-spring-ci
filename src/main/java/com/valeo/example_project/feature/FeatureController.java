package com.valeo.example_project.feature;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Features Resource/endpoints.
 * endpoints:
 * GET {host}/features: returns all features.
 * GET {host}/features/{id}: returns the feature with the provided id.
 *
 * @author Hossam Khalil.
 */
@RequestMapping("features")
@RestController
@Slf4j
public class FeatureController {

    @Autowired
    private FeatureService service;

    @GetMapping(path = "")
    public List<Feature> getAllFeatures() {
        log.info("Get all features endpoint is triggered.");
        return service.getAll();
    }

    @GetMapping(path = "{id}")
    public Feature getFeature(@PathVariable("id") int id) {
        log.info("Get feature endpoint is triggered with id <{}>.",id);
        return service.getOne(id);
    }

}
