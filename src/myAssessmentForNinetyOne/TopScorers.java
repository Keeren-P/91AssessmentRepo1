package myAssessmentForNinetyOne;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


public class TopScorers {
    public static void printTopScorers() {
        String highestScoreQuery = "SELECT MAX(score) AS max_score FROM Students"; // Get the highest score
        String topScorersQuery = "SELECT first_name, second_name, score FROM Students WHERE score = ? ORDER BY first_name, second_name"; // Get students with max score

        try (Connection conn = H2Database.connect()) {

            // Get the highest score
            try (PreparedStatement stmt = conn.prepareStatement(highestScoreQuery);
                 ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    int highestScore = rs.getInt("max_score");

                    // Get students with the highest score
                    try (PreparedStatement pstmt = conn.prepareStatement(topScorersQuery)) {
                        pstmt.setInt(1, highestScore); // Set the highest score as the parameter
                        ResultSet topScorers = pstmt.executeQuery(); // Execute query to fetch students

                        // Use a Set to avoid duplicates
                        Set<String> topScorerNames = new HashSet<>();
                        while (topScorers.next()) {
                            String fullName = topScorers.getString("first_name") + " " + topScorers.getString("second_name");
                            topScorerNames.add(fullName); // Add names to the set
                        }

                        // Print results
                        if (!topScorerNames.isEmpty()) {
                            for (String name : topScorerNames) {
                                System.out.println(name);
                            }
                            System.out.println("Score: " + highestScore);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
