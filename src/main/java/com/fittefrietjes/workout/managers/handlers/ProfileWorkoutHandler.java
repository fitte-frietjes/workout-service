package com.fittefrietjes.workout.managers.handlers;

import com.fittefrietjes.workout.managers.interfaces.iProfileWorkoutHandler;
import com.fittefrietjes.workout.models.ProfileWorkout;

import java.util.ArrayList;
import java.util.List;

public class ProfileWorkoutHandler implements iProfileWorkoutHandler {

    List<ProfileWorkout> profileWorkouts = new ArrayList<>();


    public ProfileWorkoutHandler() {
        profileWorkouts.add(new ProfileWorkout(1, 1, 1, 200));
        profileWorkouts.add(new ProfileWorkout(2, 2, 3, 500));
        profileWorkouts.add(new ProfileWorkout(3, 1, 5, 200));
        profileWorkouts.add(new ProfileWorkout(4, 7, 5, 50));
        profileWorkouts.add(new ProfileWorkout(5, 1, 10, 1200));
    }

    /**
     * get ProfileWorkout by id
     *
     * @param id
     * @return
     */
    @Override
    public ProfileWorkout get(int id) {
        for (ProfileWorkout pw : profileWorkouts) {
            if (pw.getId() == id)
                return pw;
        }
        return null;
    }

    /**
     * Get all ProfileWorkouts by profile ID
     *
     * @return
     */
    @Override
    public List<ProfileWorkout> getByProfile(int profileID) {
        List<ProfileWorkout> list = new ArrayList<>();
        for (ProfileWorkout pw : profileWorkouts) {
            if (pw.getProfileId() == profileID)
                list.add(pw);
        }
        return list;
    }

    /**
     * Get all ProfileWorkouts by workout ID
     *
     * @return
     */
    @Override
    public List<ProfileWorkout> getByWorkout(int workoutID) {
        List<ProfileWorkout> list = new ArrayList<>();
        for (ProfileWorkout pw : profileWorkouts) {
            if (pw.getWorkoutId() == workoutID)
                list.add(pw);
        }
        return list;
    }

    /**
     * Create a new ProfileWorkout
     *
     * @param profileWorkout
     * @return
     */
    @Override
    public ProfileWorkout create(ProfileWorkout profileWorkout) {
        return null;
    }

    /**
     * Update an ProfileWorkout
     *
     * @param profileWorkout
     * @return
     */
    @Override
    public ProfileWorkout update(ProfileWorkout profileWorkout) {
        return null;
    }

    /**
     * Delete an ProfileWorkout
     *
     * @param profileWorkout
     * @return
     */
    @Override
    public boolean delete(ProfileWorkout profileWorkout) {
        return false;
    }
}
