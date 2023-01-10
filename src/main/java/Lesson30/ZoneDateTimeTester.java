package Lesson30;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ZoneDateTimeTester {
    public static void main(String[] args) {
        String text = "2022-12-20T00:35:47.023323700+02:00[Europe/Helsinki]";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(text);
        System.out.println(zonedDateTime);

        ZonedDateTime now = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
        System.out.println(now);

        ZonedDateTime pacific = now.withZoneSameInstant(ZoneId.of("Pacific/Midway"));
        System.out.println(pacific);


        Date date = new Date(84, Calendar.NOVEMBER, 10);
        System.out.println(new SimpleDateFormat("dd MMMM yyyy", new Locale("ru")).format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 10);
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        System.out.println(calendar.getTime());


        // момент времени без привязки к временной зоне
        Instant instant = Instant.parse("2022-12-20T00:35:47.023323700Z");

    }
}
