//Tests the applications connection to the database 'ExerciseData'

package Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public TestConnection() {
    }

    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercisedata", "root", "password");
            System.out.println("Connection made to connection pool");
        } catch (SQLException | ClassNotFoundException var11) {
            var11.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var10) {
                    var10.printStackTrace();
                }
            }

        }

    }
}