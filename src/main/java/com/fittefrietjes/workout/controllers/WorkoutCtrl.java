package com.fittefrietjes.workout.controllers;

import com.fittefrietjes.workout.enums.Aspect;
import com.fittefrietjes.workout.models.ProfileWorkout;
import com.fittefrietjes.workout.models.Workout;
import com.fittefrietjes.workout.models.WorkoutFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Workout getWorkoutForProfileId(@PathVariable("profileId") int profileId){
        Aspect aspect = Aspect.RANDOM;

        var workout = workoutFactory.constructWorkout(aspect);

        return workout;
    }



    @Operation(summary = "Post a profileWorkout object",
            description = "Save a new profileWorkout object ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Post successful",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while creating profileWorkout",
                    content = {@Content}
            ),
    })
    @PostMapping("/addWorkout")
    public ResponseEntity CreateNewWorkoutForProfile(@RequestBody ProfileWorkout profileWorkout){

        // TODO: Save to in memory database
        profileWorkout.setId(1);

        return ResponseEntity.ok(profileWorkout);
    }

}
