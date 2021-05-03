package com.fittefrietjes.workoutservice.models;

import com.fittefrietjes.workoutservice.enums.Aspect;
import com.fittefrietjes.workoutservice.enums.Category;
import com.fittefrietjes.workoutservice.enums.Level;

public class CardioWorkout extends Workout{

    public CardioWorkout(int id, String name, String description) {
        super(id, Aspect.CARDIO, Level.BEGINNER, Category.LEGS, name, description);
    }
}