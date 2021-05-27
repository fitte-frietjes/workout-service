package com.fittefrietjes.workout.managers.interfaces;

import com.fittefrietjes.workout.models.ProfileWorkout;

import java.util.List;

public interface iProfileWorkoutHandler {

    /**
     * get ProfileWorkout by id
     * @param id
     * @return
     */
    ProfileWorkout get(int id);

    /**
     *  Get all ProfileWorkouts by profile ID
     * @param profileID Identifier of profile
     * @return
     */
    List<ProfileWorkout> getByProfile(int profileID);

    /**
     * Get all ProfileWorkouts by workout ID
     * @param workoutID Identifier of workout
     * @return
     */
    List<ProfileWorkout> getByWorkout(int workoutID);

    /**
     * Create a new ProfileWorkout
     * @param profileWorkout
     * @return
     */
    ProfileWorkout create(ProfileWorkout profileWorkout);

    /**
     * Update an ProfileWorkout
     * @param profileWorkout
     * @return
     */
    ProfileWorkout update(ProfileWorkout profileWorkout);

    /**
     * Delete an ProfileWorkout
     * @param profileWorkout
     * @return
     */
    boolean delete(ProfileWorkout profileWorkout);
}
