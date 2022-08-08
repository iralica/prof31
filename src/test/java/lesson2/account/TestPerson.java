package lesson2.account;

import lesson2.inheritance.Staff;
import lesson2.inheritance.Student;

public class TestPerson {
    public static void main(String[] args) {
        Student student = new Student("Max Kotkov", "Main Street, 22", "Music", 3);

        Staff staff = new Staff("Timur", "Nikolaev", "Philosophy", 20_000);
        System.out.println();

    }

}
