package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class User implements CRUD_OPERATIONS {
    private String Username;
    private String Password;
    boolean UserAccess = false;

    //Not finished or working need to create a function to make user first
    public static void UserLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== USer Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check fi username and password are correct
        if (username.equals("user") && password.equals("test")) {
            System.out.println("Login successful");
            boolean UserAccess = true;
        } else {
            System.out.println("Invalid username or password, please try  again");
            boolean UserAccess = false;
        }
    }

    public void CreateExercise(Scanner scanner) {
        System.out.println("Creating exercise...");
        System.out.println("Unable to create exercise ADMIN ACCESS ONLY...");
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