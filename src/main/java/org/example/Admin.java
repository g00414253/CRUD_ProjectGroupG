package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            boolean UserAccess = false;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            boolean AdminAccess = false;
        }
    }

    public void CreateExercise(Scanner scanner) {
        String URL = "jdbc:mysql://localhost:3306/exerciseData";
        String USERNAME = "root";
        String PASSWORD = "password";
        try {
            System.out.println("Creating exercise...");
            // Implement create exercise logic using scanner input
            System.out.print("Enter exercise: ");
            String exerciseName = scanner.nextLine();
            System.out.print("Enter exercise description: ");
            String exerciseDescription = scanner.nextLine();
            System.out.print("Cardio or Strength training?: ");
            int exerciseCategory = scanner.nextInt();

            System.out.print("Exercise created:");
            System.out.print("Name: " + exerciseName);
            System.out.print("Description: " + exerciseDescription);
            System.out.print("Category: " + exerciseCategory);

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // Create a PreparedStatement for inserting a new exercise
            String insertQuery = "INSERT INTO Exercise (ExerciseName, Description, CategoryId) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, exerciseName);
            preparedStatement.setString(2, exerciseDescription);
            preparedStatement.setInt(3, exerciseCategory); // Assuming category_id 1 represents strength training

            // Execute the insert statement
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Exercise created successfully");
            } else {
                System.out.println("Failed to create exercise");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ReadExercise() {
        System.out.println("Reading exercise...");
        // Implement read exercise logic using scanner input
    }

    public void UpdateExercise(Scanner scanner) {
        System.out.println("Updating exercise...");
        // Implement update exercise logic using scanner input
    }

    public void DeleteExercise(Scanner scanner) {
        String URL = "jdbc:mysql://localhost:3306/exerciseData";
        String USERNAME = "root";
        String PASSWORD = "password";

        try {
            // Get user input
            System.out.print("Enter the exercise you wish to delete: ");
            String exerciseNameToDelete = scanner.nextLine();

            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a PreparedStatement for deleting an existing exercise
            String deleteQuery = "DELETE FROM Exercise WHERE ExerciseName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, exerciseNameToDelete);

            // Execute the delete statement
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Exercise deleted successfully");
            } else {
                System.out.println("Failed to delete exercise");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
