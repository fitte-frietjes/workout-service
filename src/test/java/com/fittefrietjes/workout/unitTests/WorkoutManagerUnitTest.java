package com.fittefrietjes.workout.unitTests;

import enums.Category;
import enums.Level;
import enums.Type;
import managers.WorkoutManager;
import models.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutManagerUnitTest {

    WorkoutManager workoutManager;

    @BeforeEach
    void setup() {
        // Setup manager with a TEST workoutHandler
        workoutManager = new WorkoutManager(new TestWorkoutHandler());
    }

    @Test
    void GetAll_ShouldReturn_ListOfWorkouts() {
        var workouts = workoutManager.getAll();
        assertEquals(10, workouts.size());
    }

    @Test
    void GetById_ShouldReturn_Workout() {
        var workout = workoutManager.getById(1);
        assertEquals(1, workout.getId());
    }

    @Test
    void GetById_WithInvalidId_ShouldReturn_null() {
        var workout = workoutManager.getById(666);
        assertNull(workout);
    }

    @Test
    void GetAllByType_ShouldReturn_Workouts() {
        var workouts = workoutManager.getAllByType(Type.RUNNING);
        assertEquals(3, workouts.size());
    }

    @Test
    void GetAllByType_WithoutWorkouts_ShouldReturn_EmptyList() {
        var workouts = workoutManager.getAllByType(Type.FITNESS);
        assertEquals(0, workouts.size());
    }

    @Test
    void Update_Workout_ShouldReturn_Workout() {
        var workout = new Workout(1, Type.RUNNING, Level.BEGINNER, Category.LEGS, "Running for beginner", "blaat");
        var savedWorkout = workoutManager.update(workout);
        assertEquals(workout.getId(), savedWorkout.getId());
        assertEquals(workout.getCategory(), savedWorkout.getCategory());
        assertEquals(workout.getDescription(), savedWorkout.getDescription());
        assertEquals(workout.getLevel(), savedWorkout.getLevel());
        assertEquals(workout.getName(), savedWorkout.getName());
        assertEquals(workout.getType(), savedWorkout.getType());
    }

    @Test
    void Save_Workout_ShouldReturn_Workout() {
        var workout = new Workout(Type.RUNNING, Level.BEGINNER, Category.LEGS, "Running for beginner", "blaat");
        var savedWorkout = workoutManager.update(workout);
        assertNotNull(savedWorkout.getId());
    }


}
