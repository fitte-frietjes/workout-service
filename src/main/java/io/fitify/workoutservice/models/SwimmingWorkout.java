package io.fitify.workoutservice.models;

import io.fitify.workoutservice.enums.Aspect;
import io.fitify.workoutservice.enums.Category;
import io.fitify.workoutservice.enums.Level;

public class SwimmingWorkout extends Workout{

    public SwimmingWorkout(int id, String name, String description) {
        super(id, Aspect.SWIMMING, Level.BEGINNER, Category.WHOLE, name, description);
    }
}
