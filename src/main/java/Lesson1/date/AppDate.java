package Lesson1.date;

public class AppDate {
    public static void main(String[] args) {
        Date date = new Date(2022, 12,25);
        Date date1 = new Date(2012, 2,29);
        Date date2 = new Date(1, 01,29);
        System.out.println(date);
        System.out.println(date1.isLeapYear());
        System.out.println(date1.isValidDate());

        date1.add(date2);
        System.out.println(date1);
    }
}
