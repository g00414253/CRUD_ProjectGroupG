package org.example;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        int choice;

        WorkoutRecorder recorder = new WorkoutRecorder();

        do {
            System.out.println("=== CRUD Operations Menu ===    === Applications Menu ===     === Users Menu ===");
            System.out.println("1. Create Exercise              5. Record New Workout         9. Create User    ");
            System.out.println("2. Read Exercise                6. View Workouts             10. User Login     ");
            System.out.println("3. Update Exercise              7. 1 Rep Calculator          11. Admin Login    ");
            System.out.println("4. Delete Exercise              8. B.M.R Calculator          12. Exit           ");
            System.out.println();
            System.out.print("Enter your choice: ");
            //Possible feature(already made as they are in my IOT project)
            //Login User -Username Password - Gets created to make account - can change password
            //Login Admin - Username Password - Admin account already exists - password can be changed with old
            //1 Rep max Calculator
            //BMR Calculator
            //Macro Calculator


            // Read user input
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    user.CreateExercise(scanner);
                    break;
                case 2:
                    user.ReadExercise();
                    break;
                case 3:
                    user.UpdateExercise(scanner);
                    break;
                case 4:
                    user.DeleteExercise(scanner);
                    break;
                case 5:
                    recorder.RecordUserWorkout();
                    break;
                case 6:
                    recorder.DisplayWorkout();
                    break;
                case 7:
                 //1 Rep MAx
                    break;
                case 8:
                //B.M.R Calculator
                    break;
                case 9:
                //Create User
                    break;
                case 10:
                //User Login
                    break;
                case 11:
                //Admin Login
                    break;
                case 12:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }

            System.out.println(); // Add an empty line for better readability

        } while (choice != 7);
        scanner.close(); // Close the scanner to prevent resource leak
    }
}