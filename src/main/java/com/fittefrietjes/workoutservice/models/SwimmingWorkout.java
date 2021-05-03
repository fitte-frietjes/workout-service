package com.fittefrietjes.workoutservice.models;

import com.fittefrietjes.workoutservice.enums.Aspect;
import com.fittefrietjes.workoutservice.enums.Category;
import com.fittefrietjes.workoutservice.enums.Level;

public class SwimmingWorkout extends Workout{

    public SwimmingWorkout(int id, String name, String description) {
        super(id, Aspect.SWIMMING, Level.BEGINNER, Category.WHOLE, name, description);
    }
}
