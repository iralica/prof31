package Lesson30;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTester {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.getTime());
        calendar.set(Calendar.YEAR, 1998);
        System.out.println(calendar.getTime());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd#MM#yyyy");
        String dateString = dateFormat.format(calendar.getTime());
        System.out.println(dateString);

        SimpleDateFormat normalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(normalFormat.format(calendar.getTime()));


        // выведите на экран дату в формате
        // 10-01-23, 10, 19:51    день-месяц-год  день_года часы:минуты
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println(
                new SimpleDateFormat("dd-MM-yy, D, HH:mm").format(
                        calendar.getTime()
                )

        );

        Date mayDay =  new SimpleDateFormat("yyyy-MM-dd").parse("2023-05-01");
        System.out.println(mayDay);



    }
}
