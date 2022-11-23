package Lesson44.HomeWork.Json;

import Lesson23.Rate;
import Lesson33_34.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
// amount from    to     result
// double string  string double
// create table currency (
//      id integer PRIMARY KEY AUTOINCREMENT,
//      amount double not null,
//      f varchar not null,
//      t varchar not null,
//      result double not null
// );

// ��������� � ���� ������ ���������� ���������� ������� ���-������� frankfurter � ������� �����������

public class FrancfurterCall {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Rate usdToGbp = Request.getRate(15, "USD", "GBP");
//        saveRate(usdToGbp.amount, usdToGbp.base, "GBP", usdToGbp.rates.get("GBP"));
//        Rate usdToEur = Request.getRate(50, "USD", "EUR");
//        saveRate(usdToGbp.amount, usdToGbp.base, "EUR", usdToGbp.rates.get("EUR"));

        // Runnable  - ������� ������� ����� ����������������, �������� �� Thread-��
        // Callable - ������� ������� ����� ����������������, ������������ ���������
        // Thread - ������������ ����� ����������
        // ExecutorService - ��� Thread-�� - ����� ������� + ������� �� Runnable
        // Future - ���������, ������������ Callable
        // CompletableFuture - Future, ������� ����� ������������������ ����� ����� � ���������
        //      ����������� ���� ���������������, ��� ������� �� ExecutorService

        CompletableFuture<Rate> usdToEur = CompletableFuture.supplyAsync(
                () -> Request.getRate(150, "EUR", "GBP")
        );

//        CompletableFuture<Void> res = usdToEur.thenAccept(
//                rate -> saveRate(rate.amount, rate.base, "GBP", rate.rates.get("GBP"))
//        );

        CompletableFuture<String> res = usdToEur.thenApply(
                rate -> {
                    saveRate(rate.amount, rate.base, "GBP", rate.rates.get("GBP"));
                    return "hello";
                }
        );


        res.handle(new BiFunction<String, Throwable, String>() {
            @Override
            public String apply(String string, Throwable throwable) {
                if(throwable != null)
                {
                    // ��������������� � ������� ����������
                }
                else {
                    // ���������� ���������
                }
                return string;
            };
        }).get();

    }

    public static void saveRate(double amount, String f, String t, double result)
    {

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

            stmt.setDouble(1, amount);
            stmt.setString(2, f);
            stmt.setString(3, t);
            stmt.setDouble(4, result);
            stmt.execute();

        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
