package com.fittefrietjes.workout.managers;

import com.fittefrietjes.workout.managers.interfaces.iProfileWorkoutHandler;
import com.fittefrietjes.workout.models.ProfileWorkout;

import java.util.List;

public class ProfileWorkoutManager {

    private iProfileWorkoutHandler profileWorkoutHandler;

    /**
     * Business logic here
     * @param profileWorkoutHandler
     */
    public ProfileWorkoutManager(iProfileWorkoutHandler profileWorkoutHandler) {
        this.profileWorkoutHandler = profileWorkoutHandler;
    }

    public ProfileWorkout getById(int id){
     return  profileWorkoutHandler.get(id);
    }

    public List<ProfileWorkout> getByProfileId(int profileId){
        return profileWorkoutHandler.getByProfile(profileId);
    }

    public List<ProfileWorkout> getByWorkout(int workoutId){
        return profileWorkoutHandler.getByWorkout(workoutId);
    }

    public ProfileWorkout save(ProfileWorkout profileWorkout){
        if(profileWorkout.getId() != 0)
            return  profileWorkoutHandler.update(profileWorkout);
        else
            return profileWorkoutHandler.create(profileWorkout);
    }

    public boolean delete(ProfileWorkout profileWorkout){
        return  profileWorkoutHandler.delete(profileWorkout);
    }

}

