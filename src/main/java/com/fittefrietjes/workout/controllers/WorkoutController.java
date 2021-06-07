package com.fittefrietjes.workout.controllers;

import com.fittefrietjes.workout.enums.Type;
import com.fittefrietjes.workout.managers.WorkoutManager;
import com.fittefrietjes.workout.managers.handlers.WorkoutHandler;
import com.fittefrietjes.workout.models.Workout;
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
@RequestMapping(value = "/")
public class WorkoutController {

    @Autowired
    private WorkoutManager workoutManager;

    @Operation(summary = "Get all workouts of a given type",
            description = "Get list all workouts for a given type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Post successful",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while getting workouts",
                    content = {@Content}
            ),
    })
    @GetMapping("/type/{type}")
    public ResponseEntity getWorkoutForType(@PathVariable("type") Type type) {
        var workouts = workoutManager.getAllByType(type);
        return ResponseEntity.ok(workouts);
    }


    @Operation(summary = "Get all workouts",
            description = "Get list all workouts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Post successful",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while getting workouts",
                    content = {@Content}
            ),
    })
    @GetMapping("")
    public ResponseEntity getAllWorkouts() {
        var workouts = workoutManager.getAll();
        return ResponseEntity.ok(workouts);
    }


    @Operation(summary = "Get workout by id",
            description = "Get a workout by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Workout found",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "404",
                    description = "Workout not found",
                    content = {@Content}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while getting Workout",
                    content = {@Content}
            ),
    })
    @GetMapping("/{id}")
    public ResponseEntity getAllWorkouts(@PathVariable("id") int id) {
        var workouts = workoutManager.getById(id);

        if (workouts == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(workouts);
    }

    @Operation(summary = "Post a workout object",
            description = "Save a new workout object ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Post successful",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while saving workout",
                    content = {@Content}
            ),
    })
    @PostMapping("/")
    public ResponseEntity CreateWorkout(@RequestBody Workout workout) {
        var savedWorkout = workoutManager.create(workout);
        return ResponseEntity.ok(savedWorkout);
    }

    @Operation(summary = "Put a workout object",
            description = "Update a new workout object ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Put successful",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while saving workout",
                    content = {@Content}
            ),
    })
    @PutMapping("/")
    public ResponseEntity UpdateWorkout(@RequestBody Workout workout) {
        var savedWorkout = workoutManager.update(workout);
        return ResponseEntity.ok(savedWorkout);
    }
}
