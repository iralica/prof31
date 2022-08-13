package Lesson3.HomeWork;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    boolean isWeekDay()
    {
        return ordinal() < 5;
    }

    boolean isWeekend()
    {
        return !isWeekDay();
    }
}
