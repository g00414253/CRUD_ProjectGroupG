package Testing;

import java.sql.*;

public class UpdateTest {
    private static final String URL = "jdbc:mysql://localhost:3306/exercisedata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a PreparedStatement for updating an existing exercise
            String updateQuery = "UPDATE Exercise SET description = ? WHERE exercise_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "Bodyweight exercise targeting chest, arms, and core");
            preparedStatement.setString(2, "Push-up");

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
}
