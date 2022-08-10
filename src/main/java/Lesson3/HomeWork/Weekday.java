package Lesson3.HomeWork;

public enum Weekday {
    MONDAY(false), TUESDAY(false), WEDNESDAY(false), THURSDAY(false), FRIDAY(false), SATURDAY(true), SUNDAY(true);

    private boolean weekend;

    Weekday(boolean weekend) {
        this.weekend = weekend;
    }

    public boolean isWeekend() {
        return weekend;
    }


    public boolean isWeekDay() {
        return weekend;
    }

}
