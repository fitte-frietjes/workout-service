package io.fitify.workoutservice.models;

import io.fitify.workoutservice.enums.Aspect;
import io.fitify.workoutservice.enums.Category;
import io.fitify.workoutservice.enums.Level;

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
