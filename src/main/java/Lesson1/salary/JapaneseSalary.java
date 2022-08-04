package Lesson1.salary;

public class JapaneseSalary {
    public static void main(String[] args) {
        System.out.println(calculateSalary(50000, 20000,30));
        SalaryCalculator calculator = new SalaryCalculator(50000,20000);
        System.out.println(calculator.calculate(30));

    }


    public static double calculateSalary(double baseSalary, double yearlyIncrease, int years)
    {
        return baseSalary + yearlyIncrease*years;
    }

}
