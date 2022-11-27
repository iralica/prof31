package Lesson45;

import java.sql.SQLException;
import java.util.List;

public class DAOTester {
    public static void main(String[] args) throws SQLException {
        SalesDAO salesDAO = new SalesDAO();
//        Sales max = new Sales(4001, "Max", "Warsaw", 12);
//        salesDao.save(max);
        List<Sales> allSales = salesDAO.getAll();
        allSales.stream().forEach(
                sales -> System.out.println(sales.getName())
        );

        System.out.println("------");
        CustomerDao customerDao = new CustomerDao();
        List<Customer> allInSanJose = customerDao.getAllInCity("San Jose");
        System.out.println(allInSanJose.size());
        allInSanJose.stream().forEach(customer -> System.out.println(customer.getCname() + "|" + customer.getSales().getName()));
    }

}
