package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java8",
                    "postgres",
                    "postgres00"
            );
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
