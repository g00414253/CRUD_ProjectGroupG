package org.example;

import java.util.Scanner;

// Implement the interface in the Menu class
public class Menu implements ExerciseCRUD {
    private final User user;

    public Menu() {
        this.user = new User();
    }

    @Override
    public void createExercise(Scanner scanner) {
        user.createExercise(scanner);
    }

    @Override
    public void readExercise() {
        user.readExercise();
    }

    @Override
    public void updateExercise(Scanner scanner) {
        user.updateExercise(scanner);
    }

    @Override
    public void deleteExercise(Scanner scanner) {
        user.deleteExercise(scanner);
    }

    // Menu functionality
    public void menu() {
        Scanner scanner = new Scanner(System.in);
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
                    createExercise(scanner);
                    break;
                case 2:
                    readExercise();
                    break;
                case 3:
                    updateExercise(scanner);
                    break;
                case 4:
                    deleteExercise(scanner);
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

        scanner.close();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }
}
