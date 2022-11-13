package Lesson29;

import Lesson24.HomeWork.Car1;

import java.util.Random;

public class Probe {
    public static String getMessage(int i){
        return i > 5 ? "Hello" : "World";
    }
    public static String getMessage()
    {
        int i = new Random(10).nextInt();
        return i > 5 ? "Hello" : "World";
    }

    public static Object getCar(){
        return new Car1("Peugeot", "407", 20_000);
    }

}
