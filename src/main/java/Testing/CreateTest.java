package Testing;

import java.sql.*;

public class CreateTest {
    private static final String URL = "jdbc:mysql://localhost:3306/exercisedata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a PreparedStatement for inserting a new exercise
            String insertQuery = "INSERT INTO Exercise (ExerciseName, Description, CategoryId) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Push-up");
            preparedStatement.setString(2, "Bodyweight exercise targeting chest and arms");
            preparedStatement.setInt(3, 1); // Assuming category_id 1 represents strength training

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
}
