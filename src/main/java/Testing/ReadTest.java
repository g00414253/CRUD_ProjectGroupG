package Testing;

import java.sql.*;

public class ReadTest {
    private static final String URL = "jdbc:mysql://localhost:3306/exercisedata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create a Statement for executing a select query
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM Exercises";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Print the retrieved exercise data
            while (resultSet.next()) {
                int exerciseId = resultSet.getInt("exercise_id");
                String exerciseName = resultSet.getString("exercise_name");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
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
}
