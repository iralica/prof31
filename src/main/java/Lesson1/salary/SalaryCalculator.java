package Lesson1.salary;

public class SalaryCalculator {
    private double baseSalary = 50000;
    private double yearlyIncrease = 20000;

    public SalaryCalculator(double baseSalary, double yearlyIncrease) {
        this.baseSalary = baseSalary;
        this.yearlyIncrease = yearlyIncrease;
    }

    public double calculate (int years){

        return baseSalary+years*yearlyIncrease;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getYearlyIncrease() {
        return yearlyIncrease;
    }
}
