package Lesson30;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class LocalDateTester {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = now
                .plusDays(2)
                .plusMonths(1)
                .plusWeeks(-2);
        System.out.println(now);


        LocalDateTime timeNow = LocalDateTime.now();
        timeNow = timeNow.plusHours(2);

        timeNow = timeNow.with(ChronoField.HOUR_OF_DAY, 10);
        System.out.println(timeNow);

    }
}
