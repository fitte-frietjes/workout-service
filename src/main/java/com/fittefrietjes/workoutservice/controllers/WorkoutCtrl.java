package com.fittefrietjes.workoutservice.controllers;

import com.fittefrietjes.workoutservice.enums.Aspect;
import com.fittefrietjes.workoutservice.models.Workout;
import com.fittefrietjes.workoutservice.models.WorkoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/workout")
public class WorkoutCtrl {

    @Autowired
    private WorkoutFactory workoutFactory;

    @GetMapping("/{aspectStr}")
    public Workout getWorkoutFor(@PathVariable("aspectStr") String aspectStr){
        aspectStr = aspectStr.toUpperCase();
        Aspect aspect;

        try{
            aspect = Aspect.valueOf(aspectStr);
        }catch(Exception e){
            System.out.println(e);
            aspect = Aspect.RANDOM;
        }

        var workout = workoutFactory.constructWorkout(aspect);
        return workout;
    }
}
