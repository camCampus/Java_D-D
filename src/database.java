package src;

import java.sql.*;

public class database {

    public database() throws ClassNotFoundException {
        try {
            initDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initDatabase() throws ClassNotFoundException, SQLException {

        Connection connection =DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Dragon","root","");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW DATABASES;");
        System.out.println("Connected");
    }
}
