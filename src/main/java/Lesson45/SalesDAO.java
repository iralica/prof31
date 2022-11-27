package Lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Data Acces Object
public class SalesDAO {

    private static final String insert = "insert into salespeople values (?, ?, ?, ?);";

    private final PreparedStatement insertStatement;
    private static final String selectById = "select from salespeople where snum = ?;";
    private final PreparedStatement selectByIdStatement;
    private final Statement selectStatement;


    private static final String URL = "jdbc:sqlite:shop.db";
    public SalesDAO() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();
        selectByIdStatement = conn.prepareStatement(selectById);
        //
    }

    public Sales save(Sales sales) throws SQLException {
        insertStatement.setInt(1, sales.getId());
        insertStatement.setString(2, sales.getName());
        insertStatement.setString(3, sales.getCity());
        insertStatement.setInt(4, sales.getCommission());
        insertStatement.execute();
        return sales;
    }

    public void delete(Sales sales)
    {

    }

    public List<Sales> getAll() throws SQLException {
        List<Sales> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from salespeople;");
        ) {
            while (rs.next()) {
                result.add(
                        new Sales(
                                rs.getInt("snum"),
                                rs.getString("sname"),
                                rs.getString("citytext"),
                                rs.getInt("comm")
                        )
                );
            }
        }
        return result;
    }
    public Sales getSalesById(int snum) throws SQLException {
        Sales sales = null;
        selectByIdStatement.setInt(1, snum);
        try (
                ResultSet rs = selectByIdStatement.executeQuery();
        ) {
            if (rs.next()) {
                sales =
                        new Sales(
                                rs.getInt("snum"),
                                rs.getString("sname"),
                                rs.getString("citytext"),
                                rs.getInt("comm")
                        );
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return sales;
    }
    public List<Sales> getAllInCity(String city)
    {
        return null;
    }
}
