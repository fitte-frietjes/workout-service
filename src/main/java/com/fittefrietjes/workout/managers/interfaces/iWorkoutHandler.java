package com.fittefrietjes.workout.managers.interfaces;

import com.fittefrietjes.workout.models.Workout;
import com.fittefrietjes.workout.enums.Type;

import java.util.List;

public interface iWorkoutHandler {

    /**
     * Get workout by id
     * @param id
     * @return
     */
    Workout get(int id);

    /**
     * Get list of all workouts
     * @return
     */
    List<Workout> getAll();

    /**
     * Get list of all workouts of given type
     * @return
     */
    List<Workout> getAllOfType(Type type);

    /**
     * Update an existing workout
     * @param workout
     * @return
     */
    Workout update(Workout workout);

    /**
     * Create an workout
     * @param workout
     * @return
     */
    Workout create(Workout workout);

    /**
     * Delete a workout
     * @param workout
     * @return
     */
    boolean delete(Workout workout);

}
