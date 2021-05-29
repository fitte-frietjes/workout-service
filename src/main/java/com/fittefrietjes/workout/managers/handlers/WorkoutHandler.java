package com.fittefrietjes.workout.managers.handlers;

import com.fittefrietjes.workout.enums.Type;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;
import com.fittefrietjes.workout.managers.interfaces.iWorkoutHandler;
import com.fittefrietjes.workout.models.Workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutHandler implements iWorkoutHandler {

    List<Workout> workouts = new ArrayList<>();

    /**
     * Create a list of workouts on startup.
     * This way we dont have to setup a DB for testing/demo
     */
    public WorkoutHandler() {
        workouts.add(new Workout(1, Type.RUNNING, Level.BEGINNER, Category.LEGS,"Running for beginner","blaat"));
        workouts.add(new Workout(2, Type.RUNNING, Level.INTERMEDIATE, Category.LEGS,"Running for intermediate","blaat"));
        workouts.add(new Workout(3, Type.RUNNING, Level.ADVANCED, Category.LEGS,"Running for advanced","blaat"));

        workouts.add(new Workout(4, Type.SWIMMING, Level.BEGINNER, Category.WHOLE,"Swimming for beginner","blaat"));
        workouts.add(new Workout(5, Type.SWIMMING, Level.INTERMEDIATE, Category.WHOLE,"Swimming for intermediate","blaat"));
        workouts.add(new Workout(6, Type.SWIMMING, Level.ADVANCED, Category.WHOLE,"Swimming for advanced","blaat"));

        workouts.add(new Workout(7, Type.CARDIO, Level.BEGINNER, Category.WHOLE,"Cardio for beginner","blaat"));
        workouts.add(new Workout(8, Type.CARDIO, Level.INTERMEDIATE, Category.WHOLE,"Cardio for intermediate","blaat"));
        workouts.add(new Workout(9, Type.CARDIO, Level.ADVANCED, Category.WHOLE,"Cardio for advanced","blaat"));

        workouts.add(new Workout(10, Type.RANDOM, Level.ADVANCED, Category.ARMS,"Drinking beer","blaat"));
    }

    /**
     * Get workout by id
     *
     * @param id
     * @return
     */
    @Override
    public Workout get(int id) {
        for (Workout workout: workouts) {
            if(workout.getId() == id)
                return workout;
        }
        return null;
    }

    /**
     * Get list of all workouts
     *
     * @return
     */
    @Override
    public List<Workout> getAll() {
        return workouts;
    }

    /**
     * Get list of all workouts of given type
     *
     * @param type
     * @return
     */
    @Override
    public List<Workout> getAllOfType(Type type) {
        List<Workout> workouts = new ArrayList<>();
        for (Workout workout: workouts) {
            if(workout.getType()== type)
                workouts.add(workout);
        }
        return workouts;
    }

    /**
     * Update an existing workout
     *
     * @param workout
     * @return
     */
    @Override
    public Workout update(Workout workout) {
        return null;
    }

    /**
     * Create an workout
     *
     * @param workout
     * @return
     */
    @Override
    public Workout create(Workout workout) {
        return null;
    }

    /**
     * Delete a workout
     *
     * @param workout
     * @return
     */
    @Override
    public boolean delete(Workout workout) {
        return false;
    }
}
