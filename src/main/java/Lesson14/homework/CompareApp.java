package Lesson14.homework;

import java.util.*;

public class CompareApp {
    public static void main(String[] args) {
     Students s1 = new Students("Ann", "manager", 25);
     Students s2 = new Students("Vova", "manager", 30);
     Students s3 = new Students("Same", "accounting", 20);
     Students s4 = new Students("Dave", "engineer", 30);

     Teachers t1 = new Teachers("Andre", 20000);
     Teachers t2 = new Teachers("Andre", 20000);

     t1.addStudent(s1);
     t1.addStudent(s2);
     t1.addStudent(s3);
     t2.addStudent(s4);

        List<Teachers> teachers = new ArrayList<>();
        teachers.add(t1);
        teachers.add(t2);
        System.out.println(teachers);
        //Collections.sort(teachers, Comparator.comparing(Teachers::getStudents));
         Collections.sort(teachers, new Comparator<Teachers>() {
            @Override
            public int compare(Teachers o1, Teachers o2) {
                return Integer.compare(o1.getStudents().size(), o2.getStudents().size());
            }
        });
        System.out.println(teachers);

        Collections.sort(teachers);
        System.out.println(teachers);

    }
}
