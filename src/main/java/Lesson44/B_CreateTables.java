package Lesson44;

import java.sql.*;

public class B_CreateTables {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
        )
        {
             stmt.execute("create table if not exists salespeople (snum int primary key not null, sname text not null, city\n" +
                     "text not null, comm integer not null);");
             stmt.execute("create table if not exists  customers (cnum int primary key not null, cname text not null, city\n" +
                     "text not null, rating integer not null, snum int not null);");
             stmt.execute("create table if not exists orders (onum int primary key not null, amt int not null, odate text" +
                    "not null, cnum int not null, snum int not null);");

            System.out.println("Tables created");
        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
