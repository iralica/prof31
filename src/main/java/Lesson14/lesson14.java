package Lesson14;

import Lesson13.homework.Employee;

import java.util.*;

public class lesson14 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 24, 21000, "Maia");
        Employee e2 = new Employee(10, 34, 12000, "Max");
        Employee e3 = new Employee(12, 27, 32000, "Alex");
        Employee e4 = new Employee(22, 21, 29000, "Gerta");
        Employee e5 = new Employee(32, 22, 12000, "Tom");

        List<Employee> emps = new ArrayList<>();

        emps.addAll(Arrays.asList(e1,e2,e3,e4,e5));

        System.out.println(Collections.max(emps, new Employee.EmployeeAgeComparator()));

        Collections.sort(emps, new Employee.EmployeeNameComparator());
        System.out.println(Collections.binarySearch(emps, e3, new Employee.EmployeeNameComparator()));


        Collections.sort(emps, new Employee.EmployeeAgeComparator());
        // если класс имплементит Comparable, можно использовать Collections.sort(emps) без компаратора
        Collections.sort(emps); // используется compareTo(...) из Comparable<Employee>

        TreeSet<Employee> employees = new TreeSet<>(
                Comparator
                        .comparing(Employee::getAge)
                        .thenComparing(Employee::getName).reversed()
        );
        employees.addAll(Arrays.asList(e2,e1,e3,e5,e4));
        System.out.println(employees);

        TreeSet<String> groups = new TreeSet<>(Arrays.asList(
                "Abba",
                "Boney M",
                "Led Zeppelin",
                "Aerosmith",
                "Pearl Jam",
                "ZZ Top"
        ));

        System.out.println(groups);

        System.out.println(groups.subSet("CC Catch", "Sandra"));

        System.out.println(groups.tailSet("Fridays"));

    }
}
