package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class User implements CRUD_OPERATIONS {

    public void CreateExercise(Scanner scanner) {
        String URL = "jdbc:mysql://localhost:3306/exercisedata";
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
            String insertQuery = "INSERT INTO Exercises (exercise_name, description, category_id) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, exerciseName);
            preparedStatement.setString(2, exerciseDescription);
            preparedStatement.setInt(3, exerciseCategory); // Assuming category_id 1 represents strength training
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User newExercise = new User();
        newExercise.CreateExercise(scanner);
        scanner.close();
    }

    public void ReadExercise() {
        System.out.println("Reading exercise...");
        // Implement read exercise logic
    }

    public void UpdateExercise(Scanner scanner) {
        System.out.println("Updating exercise...");
        // Implement update exercise logic using scanner input
    }

    public void DeleteExercise(Scanner scanner) {
        System.out.println("Deleting exercise...");
        // Implement delete exercise logic using scanner input
    }
}