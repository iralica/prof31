package Lesson3.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class AppWeekDay {
    public static void main(String[] args) {
        System.out.println(Weekday.MONDAY.isWeekend());
        System.out.println(Weekday.SATURDAY.isWeekend());
        Weekday m = Weekday.valueOf("MONDAY");

    }

}
