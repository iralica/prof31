package Lesson13.homework;

import java.util.Comparator;

public class EmployeeComparable implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return Integer.compare(o1.getId(), o2.getId());
    }
}

