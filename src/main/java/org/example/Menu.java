package org.example;

import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        int choice;

        do {
            System.out.println("=== CRUD Operations Menu ===");
            System.out.println("1. Create Exercise");
            System.out.println("2. Read Exercise");
            System.out.println("3. Update Exercise");
            System.out.println("4. Delete Exercise");
            System.out.println("5. Exit");
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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }

            System.out.println(); // Add an empty line for better readability

        } while (choice != 5);
        scanner.close(); // Close the scanner to prevent resource leak
    }
}