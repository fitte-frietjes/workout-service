package com.fittefrietjes.workout.models;

import com.fittefrietjes.workout.enums.Aspect;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;

public class ProfileWorkout {

    private int id;
    private int profileId;
    private int workoutId;
    private int duration;

    public ProfileWorkout(){ }

    public ProfileWorkout(int profileId, int workoutId, int duration) {
        this.profileId = profileId;
        this.workoutId = workoutId;
        this.duration = duration;
    }

    public ProfileWorkout(int id, int profileId, int workoutId, int duration) {
        this.id = id;
        this.profileId = profileId;
        this.workoutId = workoutId;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }




}