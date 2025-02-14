package myAssessmentForNinetyOne;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDatabase {
    public static void printStudents() {
        String sql = "SELECT * FROM Students";

        try (Connection conn = H2Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " +
                        rs.getString("first_name") + ", " +
                        rs.getString("second_name") + ", " +
                        rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
