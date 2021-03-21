package io.fitify.workoutservice.models;

import io.fitify.workoutservice.enums.Aspect;
import io.fitify.workoutservice.enums.Category;
import io.fitify.workoutservice.enums.Level;

public class RunningWorkout extends Workout{

    public RunningWorkout(int id, String name, String description) {
        super(id, Aspect.RUNNING, Level.BEGINNER, Category.LEGS, name, description);
    }
}
