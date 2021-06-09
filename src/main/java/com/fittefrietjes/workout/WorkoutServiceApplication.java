package com.fittefrietjes.workout;


import managers.ProfileWorkoutManager;
import managers.WorkoutManager;
import handlers.ProfileWorkoutHandler;
import handlers.WorkoutHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WorkoutServiceApplication {

    private WorkoutHandler workoutHandler = new WorkoutHandler();
    private ProfileWorkoutHandler profileWorkoutHandler = new ProfileWorkoutHandler();


    @Bean
    public WorkoutManager workoutManager() {
        return new WorkoutManager(workoutHandler);
    }

    @Bean
    public ProfileWorkoutManager profileWorkoutManager() {
        return new ProfileWorkoutManager(profileWorkoutHandler);
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkoutServiceApplication.class, args);
    }

}
