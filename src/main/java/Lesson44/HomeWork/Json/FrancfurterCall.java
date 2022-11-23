package Lesson44.HomeWork.Json;

import Lesson23.Rate;
import Lesson33_34.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FrancfurterCall {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // shop.db - �������� �����
        try (
                // ������������ ���������� � ����� ������
                Connection conn = DriverManager.getConnection(url);
                // Statement - ������ - "sql ������" - sql �������
                PreparedStatement stmt = conn.prepareStatement(
                        "insert into currency (amount, f, t, result) values (?,?,?,?);"
                );
        )
        {
            Rate usdToGbp = Request.getRate(15, "USD", "GBP");
            stmt.setDouble(1, usdToGbp.amount);
            stmt.setString(2, usdToGbp.base);
            stmt.setString(3, "GBP");
            stmt.setDouble(4, usdToGbp.rates.get("GBP"));
            stmt.execute();

            Rate usdToEur = Request.getRate(50, "USD", "EUR");
            stmt.setDouble(1, usdToEur.amount);
            stmt.setString(2, usdToEur.base);
            stmt.setString(3, "EUR");
            stmt.setDouble(4, usdToEur.rates.get("EUR"));
            stmt.execute();
        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
