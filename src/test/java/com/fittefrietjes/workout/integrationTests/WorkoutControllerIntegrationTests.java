package com.fittefrietjes.workout.integrationTests;


import com.fittefrietjes.workout.controllers.WorkoutController;
import com.fittefrietjes.workout.enums.Category;
import com.fittefrietjes.workout.enums.Level;
import com.fittefrietjes.workout.enums.Type;
import com.fittefrietjes.workout.managers.handlers.WorkoutHandler;
import com.fittefrietjes.workout.models.Workout;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WorkoutController.class)
public class WorkoutControllerIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WorkoutHandler handler;

    List<Workout> workouts;

    @BeforeEach
    void setup() {
        workouts = new ArrayList<>();
        workouts.add(new Workout(1, Type.RUNNING, Level.BEGINNER, Category.LEGS, "TEST 1", "test1"));
        workouts.add(new Workout(2, Type.RUNNING, Level.INTERMEDIATE, Category.LEGS, "TEST 2", "test2"));
        workouts.add(new Workout(3, Type.RUNNING, Level.ADVANCED, Category.LEGS, "TEST 3", "test3"));
    }


    @Test
    void GetAll_Workouts_ShouldReturn_ListOfWorkouts() throws Exception {

        // Setup mock
        Mockito.when(handler.getAll()).thenReturn(workouts);

        // Create expected response
        var expectedResponse = new Gson().toJson(workouts);

        // Test
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void GetAll_Workouts_WithoutWorkouts_ShouldReturn_EmptyList() throws Exception {

        // Setup mock
        Mockito.when(handler.getAll()).thenReturn(new ArrayList<Workout>());

        // Create expected response
        var expectedResponse = new Gson().toJson(new ArrayList<Workout>());

        // Test
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }


    @Test
    void GetByID_ShouldReturn_Workout() throws Exception {

        // Setup mock
        Mockito.when(handler.get(1)).thenReturn(workouts.get(0));

        // Create expected response
        var expectedResponse = new Gson().toJson(workouts.get(0));

        // Test
        mvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void GetByID_ForUnknownId_ShouldReturn_NotFound() throws Exception {

        // Setup mock
        Mockito.when(handler.get(1)).thenReturn(null);

        // Test
        mvc.perform(get("/666"))
                .andExpect(status().isNotFound());
    }

    @Test
    void GetType_ShouldReturn_ListOfWorkouts() throws Exception {

        // Setup mock
        Mockito.when(handler.getAllOfType(Type.RUNNING)).thenReturn(workouts);

        // Create expected response
        var expectedResponse = new Gson().toJson(workouts);

        // Test
        mvc.perform(get("/type/RUNNING"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void GetType_WithNoWorkouts_ShouldReturn_EmptyList() throws Exception {

        // Setup mock
        Mockito.when(handler.getAllOfType(any(Type.class))).thenReturn(null);

        // Create expected response
        var expectedResponse = new Gson().toJson(null);

        // Test
        mvc.perform(get("/type/RUNNING"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void GetType_WithUnknownWorkout_ShouldReturn_BadRequest() throws Exception {
        // Test
        mvc.perform(get("/type/WANKING"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void PostWorkout_ShouldReturn_Workout() throws Exception {

        var workout = new Workout(1, Type.RUNNING, Level.BEGINNER, Category.LEGS, "Running for beginner", "blaat");

        // Setup mock
        Mockito.when(handler.create(any(Workout.class))).thenReturn(workout);

        // Create expected response
        var workoutJson = new Gson().toJson(workout);

        mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(workoutJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(workoutJson));
    }

    @Test
    void PostWorkout_InvalidWorkoud_ShouldReturn_BadRequest() throws Exception {

        mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":\"RUNNING\",\"description\":\"test1\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
