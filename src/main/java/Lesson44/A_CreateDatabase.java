package Lesson44;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A_CreateDatabase {
    public static void main(String[] args) {
        // https://www.google.com
        // tel:123
        // jdbc:sqlite:/path/to/store.db
        String url = "jdbc:sqlite:shop.db";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(url);
        )
        {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is: " + meta.getDriverName());
            System.out.println("The database was created.");
        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }

    }
}
