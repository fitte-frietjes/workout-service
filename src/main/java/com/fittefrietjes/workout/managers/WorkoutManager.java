package com.fittefrietjes.workout.managers;

import com.fittefrietjes.workout.enums.Type;
import com.fittefrietjes.workout.managers.interfaces.iWorkoutHandler;
import com.fittefrietjes.workout.models.Workout;

import java.util.List;

public class WorkoutManager {

    private iWorkoutHandler workoutHandler;

    /**
     * Business logic here
     *
     * @param workoutHandler
     */
    public WorkoutManager(iWorkoutHandler workoutHandler) {
        this.workoutHandler = workoutHandler;
    }

    public Workout getById(int id) {
        return workoutHandler.get(id);
    }

    public List<Workout> getAll() {
        return workoutHandler.getAll();
    }

    public List<Workout> getAllByType(Type type) {
        return workoutHandler.getAllOfType(type);
    }

    public Workout update(Workout workout) {
        // Checks here
        return workoutHandler.update(workout);
    }

    public Workout create(Workout workout) {
        // Checks here
        return workoutHandler.create(workout);
    }


}
