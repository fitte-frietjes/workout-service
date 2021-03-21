package io.fitify.workoutservice.controllers;

import io.fitify.workoutservice.enums.Aspect;
import io.fitify.workoutservice.enums.Category;
import io.fitify.workoutservice.enums.Level;
import io.fitify.workoutservice.models.RunningWorkout;
import io.fitify.workoutservice.models.Workout;
import io.fitify.workoutservice.models.WorkoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
