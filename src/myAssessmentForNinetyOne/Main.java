package myAssessmentForNinetyOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
	// write your code here
        String url = "jdbc:h2:./data/mydb";
        String user = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to H2 database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CreateTable.createTable();
        CSVUploader.uploadCSV("C:\\Users\\User\\Desktop\\The 91 Assessment\\TestData.csv");
        //QueryDatabase.printStudents();
        TopScorers.printTopScorers();

    }

}
