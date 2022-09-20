package Lesson13.homework;

import Lesson13.PlayerRankComparator;

import java.util.*;

import static Lesson13.homework.Employee.complexSort;

public class EmployeeAp {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>(Arrays.asList(
                new Employee(14, 25, 40000, "Sam"),
                new Employee(25, 35, 65000, "Ann"),
                new Employee(25, 35, 62000, "Aro"),
                new Employee(12, 18, 25000, "Max")
        ));
        System.out.println(emp);
        Collections.sort(emp, new EmployeeComparable());
        System.out.println("after EmployeeComp" + emp);
        Collections.sort(emp, new Employee.ageComparator());
        System.out.println("after Employee.ageComp" + emp);
        Collections.sort(emp, new Employee.salaryComparator());
        System.out.println("after Employee.salaryComp" + emp);
        Collections.sort(emp, new Employee.nameComparator());
        System.out.println("after Employee.nameComp" + emp);

        emp.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));
        System.out.println("after Lambda" + emp);

        emp.sort(
                Comparator.comparing(Employee::getAge).
                        thenComparing(Employee::getName)
        );

        List<Comparator<Employee>> comparators = new ArrayList<>() {{
            add(new Employee.salaryComparator());
            add(new Employee.nameComparator());
            add(new Employee.ageComparator());
            add(new Employee.idComparator());}};
        complexSort(emp, comparators);
        System.out.println(emp);
    }
}
