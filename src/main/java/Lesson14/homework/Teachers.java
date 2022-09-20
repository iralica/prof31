package Lesson14.homework;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Teachers implements Comparator<Teachers> {
    String name;
    int salary;

    public Teachers(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compare(Teachers o1, Teachers o2) {
        return 0;
    }


    public static class TeacherStudentsComparator implements Comparator<Teachers> {

        @Override
        public int compare(Teachers o1, Teachers o2) {
            TreeSet<Students> s = new TreeSet<>();
            return Integer.compare(s. ;
        }
    }



}
