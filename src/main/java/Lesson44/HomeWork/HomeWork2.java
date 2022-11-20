package Lesson44.HomeWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeWork2 {
    public static void main(String[] args) {
        String sql = "DELETE FROM customers WHERE snum = 1009";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(sql);
                Statement stmt = conn.prepareStatement(sql);
        ) {
                       stmt.executeUpdate(sql);
        } catch (
                SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
