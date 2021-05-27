package com.fittefrietjes.workout.controllers;

import com.fittefrietjes.workout.managers.ProfileWorkoutManager;
import com.fittefrietjes.workout.managers.handlers.profileWorkoutHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/profile")
public class ProfileWorkoutController {

    private ProfileWorkoutManager profileWorkoutManager = new ProfileWorkoutManager(new profileWorkoutHandler());

    @Operation(summary = "Get Profile Workout by id",
            description = "Get a Profile Workout by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ProfileWorkout found",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "404",
                    description = "ProfileWorkout not found",
                    content = {@Content}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while getting ProfileWorkout",
                    content = {@Content}
            ),
    })
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") int id) {

        var profile = profileWorkoutManager.getById(id);
        if (profile == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(profile);
    }

    @Operation(summary = "Get Profile Workouts by profile id",
            description = "Get a Profile Workouts by profile id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ProfileWorkout found",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "404",
                    description = "No ProfileWorkouts found",
                    content = {@Content}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while getting ProfileWorkout",
                    content = {@Content}
            ),
    })
    @GetMapping("/profile/{id}")
    public ResponseEntity getByProfileId(@PathVariable("id") int id) {

        var profileWorkouts = profileWorkoutManager.getByProfileId(id);
        if (profileWorkouts == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(profileWorkouts);
    }

    @Operation(summary = "Get Profile Workouts by workout id",
            description = "Get a Profile Workouts by workout id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ProfileWorkout found",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "404",
                    description = "No ProfileWorkouts found",
                    content = {@Content}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while getting ProfileWorkout",
                    content = {@Content}
            ),
    })
    @GetMapping("/workout/{id}")
    public ResponseEntity getByWorkoutId(@PathVariable("id") int id) {

        var profileWorkouts = profileWorkoutManager.getByWorkout(id);
        if (profileWorkouts == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(profileWorkouts);
    }

}
