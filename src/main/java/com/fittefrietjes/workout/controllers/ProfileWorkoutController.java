package com.fittefrietjes.workout.controllers;

import com.fittefrietjes.workout.managers.ProfileWorkoutManager;
import com.fittefrietjes.workout.managers.WorkoutManager;
import com.fittefrietjes.workout.models.ProfileWorkout;
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
@RequestMapping(value = "/profileWorkout")
public class ProfileWorkoutController {

    @Autowired
    private ProfileWorkoutManager profileWorkoutManage;

    @Autowired
    private WorkoutManager workoutManager;


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

        var profile = profileWorkoutManage.getById(id);
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

        var profileWorkouts = profileWorkoutManage.getByProfileId(id);
        if (profileWorkouts == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        for (ProfileWorkout pw : profileWorkouts) {
            var workout = workoutManager.getById(pw.getWorkoutId());
            pw.setWorkout(workout);
        }

        return ResponseEntity.ok(profileWorkouts);
    }

    @Operation(summary = "Save ProfileWorkout",
            description = "Create or update ProfileWorkout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ProfileWorkout saved",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "400",
                    description = "No ProfileWorkouts found",
                    content = {@Content}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while saving ProfileWorkout",
                    content = {@Content}
            ),
    })
    @PostMapping("")
    public ResponseEntity saveProfileWorkout(@RequestBody ProfileWorkout pw) {

        var savedPw = profileWorkoutManage.save(pw);

        if (savedPw == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        return ResponseEntity.ok(savedPw);
    }

    @Operation(summary = "Delete ProfileWorkout",
            description = "Delete a ProfileWorkout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ProfileWorkout Deleted",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(responseCode = "400",
                    description = "ProfileWorkout not deleted",
                    content = {@Content}
            ),
            @ApiResponse(responseCode = "500",
                    description = "Error while deleting ProfileWorkout",
                    content = {@Content}
            ),
    })
    @DeleteMapping("")
    public ResponseEntity deleteProfileWorkout(@RequestBody ProfileWorkout pw) {

        var result = profileWorkoutManage.delete(pw);

        if (result)
            return ResponseEntity.ok(null);
        else
            return ResponseEntity.badRequest().body(null);
    }

}
