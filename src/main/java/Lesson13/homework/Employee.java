package Lesson13.homework;

import java.util.Comparator;
import java.util.List;


public class Employee {
    private int id;
    private int age;
    private int salary;
    private String name;

    public Employee(int id, int age, int salary, String name) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "i=" + id +
                ", a=" + age +
                ", s=" + salary +
                ", n='" + name + '\'' +
                '}';
    }

    public static class nameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static class ageComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee a1, Employee a2) {
            return Integer.compare(a1.getAge(), a2.getAge());
        }
    }

    public static class salaryComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee s1, Employee s2) {
            return Integer.compare(s1.getSalary(), s2.getSalary());
        }
    }
    public static class idComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee s1, Employee s2) {
            return Integer.compare(s1.getId(), s2.getId());
        }
    }
    public static void complexSort(List<Employee> emps, List<Comparator<Employee>> comparators){
        if (comparators.size() == 0)
            return;
        Comparator<Employee> c = comparators.get(0);
        for (int i = 1; i < comparators.size(); ++i)
            c = c.thenComparing(comparators.get(i));
        emps.sort(c);
    }
}
