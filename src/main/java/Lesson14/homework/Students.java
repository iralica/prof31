package Lesson14.homework;

import java.util.Comparator;

public class Students implements Comparator<Students> {
    String name, speciality;
    int age;

    public Students(String name, String speciality, int age) {
        this.name = name;
        this.speciality = speciality;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Students o1, Students o2) {
        return 0;
    }
}
