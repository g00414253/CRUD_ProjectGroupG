package org.example;

import java.sql.*;
import java.util.Scanner;

public class Admin implements CRUD_OPERATIONS{
    boolean AdminAccess;

    public void AdminLogin() {
        System.out.println("=== Admin Login ===");
        String username = InputUtils.readString("Enter username: ");
        String password = InputUtils.readString("Enter password: ");

        // Authenticate admin
        String username1 = "Admin";
        String password1 = "password";
        if (username.equals(username1) && password.equals(password1)) {
            System.out.println("Admin login successful.");
            AdminAccess = true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            AdminAccess = false;
        }
    }

    public boolean isAdminAccess() {
        return AdminAccess;
    }

    public void Logout() {
        AdminAccess = false;
    }

    public void CreateExercise(Scanner scanner) {
        String URL = "jdbc:mysql://localhost:3306/exerciseData";
        String USERNAME = "root";
        String PASSWORD = "password";
        try {
            String exerciseName = InputUtils.readString("Enter exercise: ");
            String exerciseDescription = InputUtils.readString("Enter exercise description: ");
            int exerciseCategory = InputUtils.readInt("Enter exercise category: ");

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

        try{
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
            String exerciseName = InputUtils.readString("Enter new name: ");
            String exerciseDescription = InputUtils.readString("Enter new description: ");
            int exerciseCategory = InputUtils.readInt("1. Strength or 2. Cardio: ");

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
            String exerciseNameToDelete = InputUtils.readString("Enter the exercise you wish to delete: ");

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
