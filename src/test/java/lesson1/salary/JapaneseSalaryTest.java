package lesson1.salary;

import Lesson1.salary.JapaneseSalary;
import Lesson1.salary.SalaryCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JapaneseSalaryTest {

    @Test
    public void testSalary (){

        assertEquals(
                650_000, JapaneseSalary.calculateSalary(50_000, 20_000, 30),
                0.000001);
        ;
    }

    @Test
    public void testSalaryCalculator (){
        SalaryCalculator calculator = new SalaryCalculator(50000, 20000);
        assertEquals(
                650_000,
                calculator.calculate( 30),
                0.000001);
        ;
    }
}
