package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkoutRecorder {
    private static class WorkoutSession {
        private String date;
        private String exercise;
        private int sets;
        private int reps;
        private int weight;
        private boolean choice=true;

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

    public void RecordUserWorkout() {
        Scanner scanner = new Scanner(System.in);

        String date = InputUtils.readString("Enter YYYY-MM-DD: ");

        boolean choice;

        do {
            try {
                String exercise = InputUtils.readString("Enter exercise:");

                System.out.println("Enter number of sets:");
                int sets = scanner.nextInt();

                System.out.println("Enter number of reps:");
                int reps = scanner.nextInt();

                System.out.println("Enter weight (in kilograms):");
                int weight = scanner.nextInt();

                recordWorkout(date, exercise, sets, reps, weight);

                choice = InputUtils.readBoolean("Do you have another entry to make (true/false):");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
                choice = true; // Set choice to true to retry input
            }
        } while (choice);
    }

    public void DisplayWorkout() {
        System.out.println("=== Workout History ===");

        String currentDate = null; // Variable to store the current date
        boolean headerPrinted = false; // Flag to track whether header has been printed for current date

        for (WorkoutSession session : workoutSessions) {
            // Check if the date has changed since the last session
            if (currentDate == null || !currentDate.equals(session.getDate())) {
                currentDate = session.getDate();
                System.out.println("Date: " + currentDate);
                headerPrinted = false; // Reset the flag for the new date
            }

            // Print header only once per date
            if (!headerPrinted) {
                System.out.printf("%-15s%-10s%-10s%-10s%n",
                        "Exercise", "Sets", "Reps", "Weight");
                System.out.println("-".repeat(45)); // Underline the header
                headerPrinted = true; // Set the flag to true after printing the header
            }

            // Print exercise details with aligned columns
            System.out.printf("%-15s%-10d%-10d%-10d%n",
                    session.getExercise(), session.getSets(), session.getReps(), session.getWeight());
            System.out.println();
        }
    }

}
