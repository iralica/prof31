package Lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String insert = "insert into customers values (?, ?, ?, ?, ?);";
    private static final String delete = "delete from customers where cnum = ?";

    private static final String selectByCity = "select * from customers where city-text = ?";
    private final PreparedStatement selectByCityStatement;
    private final PreparedStatement insertStatement;
    private final Statement selectStatement;

    private final PreparedStatement deleteStatement;

    private static final String URL = "jdbc:sqlite:shop.db";
    public CustomerDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();
        deleteStatement = conn.prepareStatement(delete);
        selectByCityStatement = conn.prepareStatement(selectByCity);
    }

    public Customer save(Customer customer) throws SQLException {
        insertStatement.setInt(1, customer.getId());
        insertStatement.setString(2, customer.getCname());
        insertStatement.setString(3, customer.getCity());
        insertStatement.setInt(4, customer.getRating());
        insertStatement.setInt(5, customer.getSales().getId());
        insertStatement.execute();
        return customer;
    }

    public void delete(Customer customer) throws SQLException {
        deleteStatement.setInt(1, customer.getId());
        deleteStatement.execute();
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from customers;");
        )
        {
            getCustomersByRs(result, rs);
        }
        return result;
    }

    public List<Customer> getAllInCity(String city) throws SQLException {

        List<Customer> result = new ArrayList<>();
        selectByCityStatement.setString(1, city);
        try (
                ResultSet rs = selectByCityStatement.executeQuery();
        )
        {
            getCustomersByRs(result, rs);
        }
        return result;
    }

    public void getCustomersByRs(List<Customer> result, ResultSet rs) throws SQLException {
        SalesDAO salesDao = new SalesDAO();
        while (rs.next())
        {
            Sales sales = salesDao.getSalesById(rs.getInt("snum"));
            result.add(
                    new Customer(
                            rs.getInt("cnum"),
                            rs.getString("cname"),
                            rs.getString("city"),
                            rs.getInt("rating"),
                            sales
                    )
            );
        }
    }
}
