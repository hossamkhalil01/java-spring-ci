package com.valeo.example_project.feature;

import lombok.Data;

@Data
public class Feature {

    private int id;
    private String description = "";

    public Feature(int id) {
        this.id = id;
    }

    public Feature(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
