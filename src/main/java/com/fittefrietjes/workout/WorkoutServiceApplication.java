package com.fittefrietjes.workout;


import com.fittefrietjes.workout.managers.ProfileWorkoutManager;
import com.fittefrietjes.workout.managers.WorkoutManager;
import com.fittefrietjes.workout.managers.handlers.ProfileWorkoutHandler;
import com.fittefrietjes.workout.managers.handlers.WorkoutHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WorkoutServiceApplication {

    private WorkoutHandler workoutHandler = new WorkoutHandler();
    private ProfileWorkoutHandler profileWorkoutHandler = new ProfileWorkoutHandler();


    @Bean
    public WorkoutManager workoutManager(){
        return  new WorkoutManager(workoutHandler);
    }

    @Bean
    public ProfileWorkoutManager profileWorkoutManager(){
        return new ProfileWorkoutManager(profileWorkoutHandler);
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkoutServiceApplication.class, args);
    }

}
