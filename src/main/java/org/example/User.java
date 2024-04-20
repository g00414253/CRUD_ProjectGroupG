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

    public User() {
    }

    public boolean UserLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== User Login ===");
        String username = InputUtils.readString("Enter username: ");
        String password = InputUtils.readString("Enter password: ");

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
        String newUsername = InputUtils.readString("Enter new username: ");
        String newPassword = InputUtils.readString("Enter new password: ");

        // Create and return a new User object
        return new User(newUsername, newPassword);
    }


    public boolean isUserAccess() {
        return UserAccess;
    }

    public boolean Logout() {
        return UserAccess = false;
    }

    public boolean Login() {
        return UserAccess = true;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
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