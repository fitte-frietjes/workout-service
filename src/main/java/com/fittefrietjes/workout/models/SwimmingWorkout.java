package com.fittefrietjes.workout.models;

import com.fittefrietjes.workout.enums.Aspect;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;

public class SwimmingWorkout extends Workout{

    public SwimmingWorkout(int id, String name, String description) {
        super(id, Aspect.SWIMMING, Level.BEGINNER, Category.WHOLE, name, description);
    }
}
