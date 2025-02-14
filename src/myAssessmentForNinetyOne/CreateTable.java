package myAssessmentForNinetyOne;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class CreateTable {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Students (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "first_name VARCHAR(255), " +
                "second_name VARCHAR(255), " +
                "score INT)";

        try (Connection conn = H2Database.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            //System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

