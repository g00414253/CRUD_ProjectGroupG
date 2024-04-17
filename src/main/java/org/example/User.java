package org.example;

public class User implements ExerciseCRUD {
    @Override
    public void createExercise(Scanner scanner) {
        System.out.println("Creating exercise...");
        // Implement create exercise logic using scanner input
    }

    @Override
    public void readExercise() {
        System.out.println("Reading exercise...");
        // Implement read exercise logic
    }

    @Override
    public void updateExercise(Scanner scanner) {
        System.out.println("Updating exercise...");
        // Implement update exercise logic using scanner input
    }

    @Override
    public void deleteExercise(Scanner scanner) {
        System.out.println("Deleting exercise...");
        // Implement delete exercise logic using scanner input
    }