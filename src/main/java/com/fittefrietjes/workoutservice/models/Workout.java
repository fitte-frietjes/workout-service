package com.fittefrietjes.workoutservice.models;

import com.fittefrietjes.workoutservice.enums.Aspect;
import com.fittefrietjes.workoutservice.enums.Category;
import com.fittefrietjes.workoutservice.enums.Level;

public class Workout {
    private int id;
    private Aspect aspect;
    private Level level;
    private Category category;
    private String name;
    private String description;

    public Workout(int id, Aspect aspect, Level level, Category category, String name, String description) {
        this.id = id;
        this.aspect = aspect;
        this.level = level;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Aspect getAspect() {
        return aspect;
    }

    public Level getLevel() {
        return level;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
