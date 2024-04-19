package org.example;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Application starts with one pre-made user
        User user = new User("User123", "Pass123");

        //Admin details are pre-created
        Admin admin = new Admin();

        int choiceMenu;
        int choiceUser;
        int choiceAdmin;
        WorkoutRecorder recorder = new WorkoutRecorder();

        //Checks for user login
         user.isUserAccess();
        //Checks for admins login
         admin.isAdminAccess();

        System.out.println("User logged in: " + user.isUserAccess());
        System.out.println("Admin logged in: " + admin.isAdminAccess());

        // Print initial menu for login options
        System.out.println("=== Users Menu ===");
        System.out.println("1. Create User");
        System.out.println("2. User Login");
        System.out.println("3. Admin Login");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        choiceMenu = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choiceMenu) {
            case 1:
                // Implement user creation method
                break;
            case 2:
                if (!user.isUserAccess()) {
                    user.UserLogin();
                    // Only prompt for login if user is not already logged in
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
        //Checks for user login
        user.isUserAccess();
        //Checks for admins login
        admin.isAdminAccess();

        System.out.println("User logged in: " + user.isUserAccess());
        System.out.println("Admin logged in: " + admin.isAdminAccess());

        // After the login, check which menu to display
        if (admin.isAdminAccess()) {
            // Print CRUD Operations Menu
            System.out.println("=== CRUD Operations Menu ===");
            System.out.println("1. Create Exercise");
            System.out.println("2. Read Exercise");
            System.out.println("3. Update Exercise");
            System.out.println("4. Delete Exercise");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            System.out.println();
            // Read user input
            choiceAdmin = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            // Print CRUD Operations Menu for admin
            // Implement the loop to handle admin actions
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
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } else if (user.isUserAccess()) {
            // Print Applications Menu
            System.out.println("=== Applications Menu ===");
            System.out.println("1. Record New Workout");
            System.out.println("2. View Workouts");
            System.out.println("3. 1 Rep Calculator");
            System.out.println("4. B.M.R Calculator");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            // Read user input
            choiceUser = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            // Print Applications Menu for user
            // Implement the loop to handle user actions
            switch (choiceUser) {
                case 1:
                    recorder.RecordUserWorkout();
                    break;
                case 2:
                    recorder.DisplayWorkout();
                    break;
                case 3:
                    //1 rep max
                    break;
                case 4:
                    //BMR
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}