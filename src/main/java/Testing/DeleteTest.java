package Testing;

import java.sql.*;

public class DeleteTest {
    private static final String URL = "jdbc:mysql://localhost:3306/exercisedata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a PreparedStatement for deleting an existing exercise
            String deleteQuery = "DELETE FROM Exercises WHERE exercise_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, "Push-up");

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
