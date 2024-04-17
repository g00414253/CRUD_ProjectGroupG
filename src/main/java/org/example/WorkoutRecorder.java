package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutRecorder {
    private static class WorkoutSession {
        private String date;
        private String exercise;
        private int sets;
        private int reps;
        private int weight;

        public WorkoutSession(String date, String exercise, int sets, int reps, int weight) {
            this.date = date;
            this.exercise = exercise;
            this.sets = sets;
            this.reps = reps;
            this.weight = weight;
        }

        public WorkoutSession() {
        }

        public String getDate() {
            return date;
        }

        public String getExercise() {
            return exercise;
        }

        public int getSets() {
            return sets;
        }

        public int getReps() {
            return reps;
        }

        public int getWeight() {
            return weight;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setExercise(String exercise) {
            this.exercise = exercise;
        }

        public void setSets(int sets) {
            this.sets = sets;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    private List<WorkoutSession> workoutSessions;

    public WorkoutRecorder() {
        workoutSessions = new ArrayList<>();
    }

    public void recordWorkout(String date, String exercise, int sets, int reps, int weight) {
        WorkoutSession session = new WorkoutSession(date, exercise, sets, reps, weight);
        workoutSessions.add(session);
    }

    public void displayWorkoutHistory() {
        System.out.println("=== Workout History ===");
        for (WorkoutSession session : workoutSessions) {
            System.out.println("Date: " + session.getDate());
            System.out.println("Exercise: " + session.getExercise());
            System.out.println("Sets: " + session.getSets());
            System.out.println("Reps: " + session.getReps());
            System.out.println("Weight: " + session.getWeight());
            System.out.println();
        }
    }
}
