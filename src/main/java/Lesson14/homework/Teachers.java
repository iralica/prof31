package Lesson14.homework;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Teachers implements Comparable<Teachers> {
    private  String name;
    private int salary;
    private List<Students> students = new ArrayList<>();


    public Teachers(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.students = students;
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

    public void addStudent(Students student)
    {
        if(student != null)
            students.add(student);
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    @Override
    public int compareTo(Teachers o) {
        return students.size() - o.getStudents().size();
    }
    @Override
    public String toString() {
        return getName() + " " + getStudents().size();
    }

}


