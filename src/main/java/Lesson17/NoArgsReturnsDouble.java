package Lesson17;

public interface NoArgsReturnsDouble {
    double function(); // Single abstract method

    default String hello(){ // default метод который может быть переопределен в подклассах
        return "hello";
    }

    static String anotherHello() // в интерфейсе могут быть статические методы и поля
    {
        return "Another hello";
    }

}
