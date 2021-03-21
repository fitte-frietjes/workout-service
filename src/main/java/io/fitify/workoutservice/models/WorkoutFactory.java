package io.fitify.workoutservice.models;

import io.fitify.workoutservice.enums.Aspect;

public class WorkoutFactory{

    private Workout workout;

    public Workout constructWorkout(Aspect aspect){
        switch(aspect){
            case RUNNING:
                workout = new RunningWorkout(1, "Run a marathon", "The marathon is a long-distance race with an official distance of 42.195 kilometres (26 miles 385 yards),[1] usually run as a road race. The event was instituted in commemoration of the fabled run of the Greek soldier Pheidippides, a messenger from the Battle of Marathon to Athens, who reported the victory. The marathon can be completed by running or with a run/walk strategy. There are also wheelchair divisions.");
                break;
            case SWIMMING:
                workout = new SwimmingWorkout(2, "Swim a marathon", "Marathon swimming is a class of open water swimming defined by long distances (at least 10 kilometers) and traditional rules based in English Channel swimming. Unlike marathon foot-races which have a specifically defined distance, marathon swims vary in distance. However, one commonly used minimum definition is 10 kilometers, the distance of the marathon swimming event at the Olympic Games.");
                break;
            default:
                workout = new SwimmingWorkout(3, "RANDOM workout", "Decide for yourself.");
                break;
        }
        return workout;
    }

}
