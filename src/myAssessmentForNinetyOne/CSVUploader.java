package myAssessmentForNinetyOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVUploader {
    public static void uploadCSV(String filePath) {
        String sql = "INSERT INTO Students (first_name, second_name, score) VALUES (?, ?, ?)";

        try (Connection conn = H2Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // Skip header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 3) continue; // Ensure valid row

                pstmt.setString(1, data[0].trim()); // First name
                pstmt.setString(2, data[1].trim()); // Second name
                pstmt.setInt(3, Integer.parseInt(data[2].trim())); // Score
                pstmt.executeUpdate();
            }

            //System.out.println("CSV data uploaded successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
