package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Application starts with one pre-made user
        User startUser = new User("User123", "Pass123");
        User secondUser = new User("User456", "Pass456");
        List<User> users = new ArrayList<>(); // Store created users
        users.add(startUser);
        users.add(secondUser);


        //Admin details are pre-created
        Admin admin = new Admin();

        WorkoutRecorder recorder = new WorkoutRecorder();


        do {
            // Print the list of users
            System.out.println("=== List of Users ===");
            for (User u : users) {
                System.out.println("Username: " + u.getUsername());
            }
            System.out.println();

            // Print initial menu for login options
            System.out.println("=== Users Menu ===");
            System.out.println("1. Create User");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.println();
            int choiceMenu = InputUtils.readInt("Enter your choice: ");

            switch (choiceMenu) {
                case 1:
                    // Create a new user
                    User newUser = User.UserCreate();
                    System.out.println("User created successfully: " + newUser.getUsername());
                    // Log out all other users
                    for (User u : users) {
                        u.Logout();
                    }
                    // Add the new user to the list of users
                    users.add(newUser);
                    newUser.Login();
                    break;
                case 2:
                        System.out.println("Enter user credentials:");
                        String username = InputUtils.readString("Enter username: ");
                        String password = InputUtils.readString("Enter password: ");
                        // Check if the entered credentials match any user
                        for (User u : users) {
                            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                                // If match found, log in the user
                                u.Login();
                                System.out.println("Logged in successfully: " + u.getUsername());
                                break;
                            } else {
                                System.out.println("Invalid credentials");
                            }
                        }
                    break;
                case 3:
                    if (!admin.isAdminAccess()) {
                        admin.AdminLogin();
                        // Only prompt for login if admin is not already logged in
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            // After the login, check which menu to display
            while (admin.isAdminAccess()) {
                // Print CRUD Operations Menu
                System.out.println("=== CRUD Operations Menu ===");
                System.out.println("1. Create Exercise");
                System.out.println("2. Read Exercise");
                System.out.println("3. Update Exercise");
                System.out.println("4. Delete Exercise");
                System.out.println("5. Log out");
                System.out.println("6. Exit");
                System.out.println();
                System.out.println();
                // Read user input
                int choiceAdmin = InputUtils.readInt("Enter your choice: ");

                switch (choiceAdmin) {
                    case 1:
                        admin.CreateExercise(scanner);
                        break;
                    case 2:
                        admin.ReadExercise();
                        break;
                    case 3:
                        admin.UpdateExercise(scanner);
                        break;
                    case 4:
                        admin.DeleteExercise(scanner);
                        break;
                        case 5:
                        admin.Logout();
                        System.out.println("Logged out successfully.");
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
                for (User u : users) {
                    while (u.isUserAccess()) {
                        // Print Applications Menu
                        System.out.println("=== Applications Menu ===");
                        System.out.println("1. Record New Workout");
                        System.out.println("2. View Workouts");
                        System.out.println("3. 1 Rep Calculator");
                        System.out.println("4. B.M.R Calculator");
                        System.out.println("5. Log out");
                        System.out.println("6. Exit");
                        System.out.println();
                        int choiceUser = InputUtils.readInt("Enter your choice: ");

                        switch (choiceUser) {
                            case 1:
                                recorder.RecordUserWorkout();
                                break;
                            case 2:
                                recorder.DisplayWorkout();
                                break;
                            case 3:
                                RepMax.RM();
                                System.out.println();
                                break;
                            case 4:
                                BMRCalculator.BMI();
                                System.out.println();
                                break;
                            case 5:
                                u.Logout();
                                System.out.println("Logged out successfully.");
                                break;
                            case 6:
                                System.out.println("Exiting...");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }
                }
        }while(true);
    }
}