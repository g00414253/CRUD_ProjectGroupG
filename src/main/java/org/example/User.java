package org.example;

import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class User implements CRUD_OPERATIONS {
    private final String Username;
    private  final String Password;
    boolean UserAccess;
    private List<WorkoutRecorder> workoutRecorders;

    public User(String username, String password) {
        Username = username;
        Password = password;
        workoutRecorders = new ArrayList<>();
    }

    public static User UserCreate() {
        System.out.println("=== Create User ===");
        String newUsername = InputUtils.readString("Enter new username: ");
        String newPassword = InputUtils.readString("Enter new password: ");

        // Create and return a new User object
        return new User(newUsername, newPassword);
    }


    public boolean isUserAccess() {
        return UserAccess;
    }

    public void Logout() {
        UserAccess = false;
    }

    public void Login() {
        UserAccess = true;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void CreateExercise(Scanner scanner) {
        System.out.println("Creating exercise...");
        System.out.println("Unable to create exercise ADMIN ACCESS ONLY...");
    }

    public void ReadExercise() {
        System.out.println("Reading exercise...");
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
        System.out.println("Updating exercise...");
        System.out.println("Unable to update exercise ADMIN ACCESS ONLY...");
    }

    public void DeleteExercise(Scanner scanner) {
        System.out.println("Deleting exercise...");
        System.out.println("Unable to delete exercise ADMIN ACCESS ONLY...");
    }

    public void addWorkoutRecorder(WorkoutRecorder recorder) {
        workoutRecorders.add(recorder);
    }

    public List<WorkoutRecorder> getWorkoutRecorders() {
        return workoutRecorders;
    }
}