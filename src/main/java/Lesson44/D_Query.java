package Lesson44;

import java.sql.*;

public class D_Query {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                // устновка соединения
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from salespeople;");
                PreparedStatement pstm = conn.prepareStatement("select * from salespeople;")
        ) {
            while (rs.next())
            {
                int snum = rs.getInt("snum");
                String sname = rs.getString("sname");
                String city = rs.getString("city");
                int comm = rs.getInt("comm");
                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);

            }
            pstm.setInt(1, 14);
            ResultSet rs1 =  pstm.executeQuery();
        } catch (
                SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }

    }
}
