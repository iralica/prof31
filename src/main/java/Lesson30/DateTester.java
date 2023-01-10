package Lesson30;

import java.util.Date;
import java.util.Locale;

public class DateTester {
    public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println("current date: " + currentDate);

        Date oldDate = new Date(1234567890L);
        System.out.println(oldDate);

        System.out.println(currentDate.before(oldDate));
        System.out.println(currentDate.compareTo(oldDate));

        System.out.println(String.format("%tc", currentDate)); // Tue Jan 10 19:24:02 CET 2023
        System.out.println(String.format("%tD", currentDate)); //
        System.out.println(String.format("%tF", currentDate));
        System.out.println(String.format("%tr", currentDate));
        System.out.println(String.format("%tz", currentDate));
        System.out.println(String.format("%tZ", currentDate));
        System.out.println(String.format("%tc", currentDate)); // Tue Jan 10 19:24:02 CET 2023
        System.out.println(String.format("%tD", currentDate)); // 01/10/23
        System.out.println(String.format("%tF", currentDate)); // 2023-01-10
        System.out.println(String.format("%tr", currentDate)); // 07:24:02 PM
        System.out.println(String.format("%tz", currentDate)); // +0100
        System.out.println(String.format("%tZ", currentDate)); // CET

        Locale locale = new Locale("de");
        Locale.setDefault(locale);
        System.out.println(String.format("%tc", currentDate)); // Tue Jan 10 19:24:02 CET 2023
        System.out.println(String.format("%tD", currentDate)); // 01/10/23




    }
}
