package Lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String insert = "insert into customers values (?, ?, ?, ?, ?);";
    private final PreparedStatement insertStatement;
    private final Statement selectStatement;

    private static final String URL = "jdbc:sqlite:shop.db";
    public CustomerDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();
        //
    }

    public Customer save(Customer customer) throws SQLException {
        insertStatement.setInt(1, customer.getCnum());
        insertStatement.setString(2, customer.getCname());
        insertStatement.setString(3, customer.getCity());
        insertStatement.setInt(4, customer.getRating());
        insertStatement.setInt(5, customer.getSnum());
        insertStatement.execute();
        return customer;
    }

    public void delete(Customer customer)
    {

    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from customers;");
        )
        {
            while (rs.next())
            {
                result.add(
                        new Customer(
                                rs.getInt("cnum"),
                                rs.getString("cname"),
                                rs.getString("city"),
                                rs.getInt("rating"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }

    public List<Sales> getAllInCity(String city)
    {
        return null;
    }
}
