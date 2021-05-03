package com.fittefrietjes.workoutservice.models;

import com.fittefrietjes.workoutservice.enums.Aspect;
import com.fittefrietjes.workoutservice.enums.Category;
import com.fittefrietjes.workoutservice.enums.Level;

public class RunningWorkout extends Workout{

    public RunningWorkout(int id, String name, String description) {
        super(id, Aspect.RUNNING, Level.BEGINNER, Category.LEGS, name, description);
    }
}
