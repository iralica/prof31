package Lesson44.HomeWork;

import java.sql.*;

public class DeleteRow {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        String sql = "DELETE FROM customers WHERE snum = 1009";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

                       pstmt.executeUpdate(sql);
        } catch (
                SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
