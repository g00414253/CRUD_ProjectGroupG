package org.example;

import java.util.Scanner;


public class User implements CRUD_OPERATIONS {
    private  String Username;
    private  String Password;
    boolean UserAccess;

    public User(String username, String password) {
        Username = username;
        Password = password;
    }

    public boolean UserLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== User Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate user
        if (username.equals(Username) && password.equals(Password)) {
            System.out.println("User login successful.");
           return UserAccess=true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return UserAccess=false;
        }
    }

    public static User UserCreate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Create User ===");
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        // Create and return a new User object
        return new User(newUsername, newPassword);
    }


    public boolean isUserAccess() {
        return UserAccess;
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