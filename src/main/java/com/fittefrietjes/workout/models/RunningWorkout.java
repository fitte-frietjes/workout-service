package com.fittefrietjes.workout.models;

import com.fittefrietjes.workout.enums.Aspect;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;

public class RunningWorkout extends Workout{

    public RunningWorkout(int id, String name, String description) {
        super(id, Aspect.RUNNING, Level.BEGINNER, Category.LEGS, name, description);
    }
}
