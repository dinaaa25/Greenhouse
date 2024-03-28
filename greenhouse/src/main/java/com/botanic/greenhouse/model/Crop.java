package com.botanic.greenhouse.model;

import jakarta.persistence.*;

@Entity
@Table
public class Crop {
    private String name;
    private String description;

    @Id
    @GeneratedValue
    final Integer id;

    public Crop() {
        id = -1;
    }

    public Crop(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }
}
