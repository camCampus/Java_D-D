package src;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class database {

    public database() throws ClassNotFoundException {
        try {
            initDatabase();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void initDatabase() throws ClassNotFoundException {
        Class.forName("mysql-connector-j-8.0.32.jar");

    }
}
