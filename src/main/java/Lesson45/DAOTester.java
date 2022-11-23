package Lesson45;

import java.sql.SQLException;
import java.util.List;

public class DAOTester {
    public static void main(String[] args) throws SQLException {
        SalesDAO salesDao = new SalesDAO();
        //Sales max = new Sales(4001, "Max", "Warsaw", 12);
        //salesDao.save(max);
        //Sales nik = new Sales(4002, "Nick", "London", 15);
        //salesDao.save(nik);
        /*List<Sales> allSales = salesDao.getAll();
        allSales.stream().forEach(
                sales -> System.out.println(sales.getName())
        );*/
        CustomerDao customerDao = new CustomerDao();
        Customer gucci = new Customer(2010, "Gucci", "Neapol", 300, 1010);
        customerDao.save(gucci);
    }
}
