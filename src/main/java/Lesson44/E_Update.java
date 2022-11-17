package Lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class E_Update {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
        ) {
            int rowsAffected = stmt.executeUpdate("update salespeople set comm=comm+1;");

            System.out.println("Table updated, rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }

}
