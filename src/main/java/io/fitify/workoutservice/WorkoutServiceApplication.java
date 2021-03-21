package io.fitify.workoutservice;

import io.fitify.workoutservice.enums.Aspect;
import io.fitify.workoutservice.models.Workout;
import io.fitify.workoutservice.models.WorkoutFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkoutServiceApplication {

	@Bean
	public WorkoutFactory getWorkoutFactory(){
		return new WorkoutFactory();
	}

	public static void main(String[] args) {

		SpringApplication.run(WorkoutServiceApplication.class, args);

	}

}
