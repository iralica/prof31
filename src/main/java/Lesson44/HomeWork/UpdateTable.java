package Lesson44.HomeWork;

import java.sql.*;

public class UpdateTable {
    public static void main(String[] args) {
       // addSales(2001, "Cristo", "Warsaw", 12);
       delete(2001);
    }
    public static void addSales(int snum, String sname, String city, int comm)
    {
        // insert into salespeople (snum, sname, citytext, comm) values (1021, 'smith', 'warsaw', 11);
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement("insert into salespeople (snum, sname, city, comm) values (?, ?, ?, ?);");
        )
        {
            pstmt.setInt(1, snum);
            pstmt.setString(2, sname);
            pstmt.setString(3, city);
            pstmt.setInt(4, comm);
            pstmt.execute();
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
    }

    public static void delete(int snum)
    {
        // insert into salespeople (snum, sname, citytext, comm) values (1021, 'smith', 'warsaw', 11);
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement("delete from salespeople where snum = ?;");
        )
        {
            pstmt.setInt(1, snum);
            pstmt.execute();
        }
        catch (SQLException e)
        {
            System.err.println(e);
        }
    }


}
