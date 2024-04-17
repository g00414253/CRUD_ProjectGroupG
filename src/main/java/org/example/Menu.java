package org.example;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        int choice;

        WorkoutRecorder recorder = new WorkoutRecorder();

        do {
            System.out.println("=== CRUD Operations Menu ===");
            System.out.println("1. Create Exercise");
            System.out.println("2. Read Exercise");
            System.out.println("3. Update Exercise");
            System.out.println("4. Delete Exercise");
            System.out.println();
            System.out.println("=== Applications Menu ===");
            System.out.println("5. Record New Workout");
            System.out.println("6. View Workouts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

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
                    System.out.println("Exiting...");
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