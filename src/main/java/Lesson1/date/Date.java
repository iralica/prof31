package Lesson1.date;

public class Date {
    private int year;
    private int month;
    private int day;
    private final int MIN_YEAR = 1;
    private final int MAX_YEAR = 9999;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day) {
        if (! isValidDate()) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (1 > day || day > getMonthLastDay()) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    @Override
    public String toString(){
        return String.format("%2d-%02d-%02d", year, month, day);
    }

    boolean isLeapYear() {
        return (getYear()%4 == 0 && getYear()%100 != 0) || (getYear()%400 == 0);
    }

    public int getMonthLastDay() {
        return daysInMonths[getMonth()-1] + (isLeapYear() && getMonthLastDay() == 2 ? 1 : 0 );
    }

    boolean isValidDate()
    {
        if (getYear() < MIN_YEAR || getYear() > MAX_YEAR) {
            return false;
        }
        if (getMonth() < 1 || getMonth() > 12) {
            return false;
        }
        int monthDays = daysInMonths[getMonth()-1] + (getMonth() == 2 && isLeapYear() ? 1 : 0);
        return 1 <= getDay() && getDay() <= monthDays;
    }

    public Date add(Date t){
        int y = 0;
        int m= 0;
        int d = 0;
        int maxDay = getMonthLastDay();
        if (getDay() +t.day >= maxDay){
            new Date(getYear(), getMonth()+1, maxDay);
            return this;
        }
        else {
            d = getDay() + t.day;
            new Date(getYear(), getMonth(), d);
            return this;
        }

    }

}
