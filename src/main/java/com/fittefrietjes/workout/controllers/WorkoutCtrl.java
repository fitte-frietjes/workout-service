package com.fittefrietjes.workout.controllers;

import com.fittefrietjes.workout.enums.Aspect;
import com.fittefrietjes.workout.models.Workout;
import com.fittefrietjes.workout.models.WorkoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/")
public class WorkoutCtrl {

    @Autowired
    private WorkoutFactory workoutFactory;

    @GetMapping("/type/{type}")
    public Workout getWorkoutForType(@PathVariable("type") String type){
        type = type.toUpperCase();
        Aspect aspect;

        try{
            aspect = Aspect.valueOf(type);
        }catch(Exception e){
            System.out.println(e);
            aspect = Aspect.RANDOM;
        }

        var workout = workoutFactory.constructWorkout(aspect);
        return workout;
    }

    @GetMapping("/{profileId}")
    public Workout getWorkoutForProfileId(@PathVariable("profileId") String profileId){
        Aspect aspect = Aspect.RANDOM;

        var workout = workoutFactory.constructWorkout(aspect);

        return workout;
    }
}
