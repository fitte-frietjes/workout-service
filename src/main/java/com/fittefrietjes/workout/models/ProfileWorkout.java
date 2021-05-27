package com.fittefrietjes.workout.models;

import com.fittefrietjes.workout.enums.Aspect;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;

public class ProfileWorkout extends Workout{

    public ProfileWorkout(int id, String name, String description) {
        super(id, Aspect.CARDIO, Level.BEGINNER, Category.LEGS, name, description);
    }
}