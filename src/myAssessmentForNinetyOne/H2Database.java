package myAssessmentForNinetyOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Database {

    private static final String JDBC_URL = "jdbc:h2:./data/mydb"; // Change path if needed
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
}
