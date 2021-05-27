package com.fittefrietjes.workout.models;

import com.fittefrietjes.workout.enums.Type;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;

public class Workout {
    private int id;
    private Type type;
    private Level level;
    private Category category;
    private String name;
    private String description;

    public Workout(int id, Type type, Level level, Category category, String name, String description) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
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
