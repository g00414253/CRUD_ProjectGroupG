package org.example;

import java.util.Scanner;

public class Admin implements CRUD_OPERATIONS{
    private static String Username= "Admin";
    private static String Password= "password";
    boolean AdminAccess = false;

public static void AdminLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Admin Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate admin
        if (username.equals(Username) && password.equals(Password)) {
            System.out.println("Admin login successful.");
            boolean AdminAccess = true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            boolean AdminAccess = false;
        }
    }

    public void CreateExercise(Scanner scanner) {
        System.out.println("Creating exercise...");
        // Implement create exercise logic using scanner input
    }

    public void ReadExercise() {
        System.out.println("Reading exercise...");
        // Implement read exercise logic
    }

    public void UpdateExercise(Scanner scanner) {
        System.out.println("Updating exercise...");
        // Implement update exercise logic using scanner input
    }

    public void DeleteExercise(Scanner scanner) {
        System.out.println("Deleting exercise...");
        // Implement delete exercise logic using scanner input
    }
}
