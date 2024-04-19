package org.example;

import java.sql.*;
import java.util.Scanner;

public class Admin implements CRUD_OPERATIONS{
    private  String Username= "Admin";
    private  String Password= "password";
    boolean AdminAccess;

    public boolean AdminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Admin Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate admin
        if (username.equals(Username) && password.equals(Password)) {
            System.out.println("Admin login successful.");
            return AdminAccess =true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return AdminAccess = false;
        }
    }

    public boolean isAdminAccess() {
        return AdminAccess;
    }

    public boolean Logout() {
        return AdminAccess = false;
    }

    public void CreateExercise(Scanner scanner) {
        String URL = "jdbc:mysql://localhost:3306/exerciseData";
        String USERNAME = "root";
        String PASSWORD = "password";
        try {
            System.out.print("Enter exercise: ");
            String exerciseName = scanner.nextLine();
            System.out.print("Enter exercise description: ");
            String exerciseDescription = scanner.nextLine();
            System.out.print("1. Strength or 2. Cardio: ");
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
        String URL = "jdbc:mysql://localhost:3306/exerciseData";
        String USERNAME = "root";
        String PASSWORD = "password";

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a Statement for executing a select query
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM Exercise";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Print the retrieved exercise data
            while (resultSet.next()) {
                int exerciseId = resultSet.getInt("ExerciseId");
                String exerciseName = resultSet.getString("ExerciseName");
                String description = resultSet.getString("Description");
                int categoryId = resultSet.getInt("CategoryId");
                System.out.println("Exercise ID: " + exerciseId + ", Name: " + exerciseName + ", Description: " + description + ", Category ID: " + categoryId);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateExercise(Scanner scanner) {
        String URL = "jdbc:mysql://localhost:3306/exerciseData";
        String USERNAME = "root";
        String PASSWORD = "password";

        try {
            // Establish connection
            System.out.print("Enter new name: ");
            String exerciseName = scanner.nextLine();
            System.out.print("Enter new description: ");
            String exerciseDescription = scanner.nextLine();
            System.out.print("1. Strength or 2. Cardio: ");
            int exerciseCategory = scanner.nextInt();

            System.out.print("Exercise Updated:");
            System.out.print("Name: " + exerciseName);
            System.out.print("Description: " + exerciseDescription);
            System.out.print("Category: " + exerciseCategory);

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a PreparedStatement for updating an existing exercise
            String updateQuery = "UPDATE Exercise SET description = ?, category = ? WHERE exercise_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, exerciseName);
            preparedStatement.setString(2, exerciseDescription);
            preparedStatement.setInt(3, exerciseCategory);

            // Execute the update statement
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Exercise updated successfully");
            } else {
                System.out.println("Failed to update exercise");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
