package Lesson44.HomeWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute("insert into 'customers' (cnum, cname, city, rating, snum) values (2009, 'Pate', 'Rate', 100, 1009) ;");
            System.out.println("Data completed");

        } catch (
                SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
