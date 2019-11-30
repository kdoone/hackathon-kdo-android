package com.abylay.hackathonproject.models;

public class MainModel {
    private String name;
    private Integer resource;

    public MainModel(String name, Integer resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }
}
