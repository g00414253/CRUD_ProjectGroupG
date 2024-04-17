package org.example;

import java.util.Scanner;

public class User implements CRUD_OPERATIONS {
    private String Username;
    private String Password;

    public void CreateExercise(Scanner scanner) {
        System.out.println("Creating exercise...");
        System.out.println("Unable to Create exercise ADMIN ACCESS ONLY...");
    }

    public void ReadExercise() {
        System.out.println("Reading exercise...");
        // Implement read exercise logic
    }

    public void UpdateExercise(Scanner scanner) {
        System.out.println("Updating exercise...");
        System.out.println("Unable to update exercise ADMIN ACCESS ONLY...");
    }

    public void DeleteExercise(Scanner scanner) {
        System.out.println("Deleting exercise...");
        System.out.println("Unable to delete exercise ADMIN ACCESS ONLY...");
    }
}