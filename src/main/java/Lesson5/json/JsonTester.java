package Lesson5.json;

import Lesson4.Lines.Point;
import com.google.gson.Gson;

public class JsonTester {
    public static void main(String[] args) {
        // объект -> текст = сериализация serialization
        // текст -> объект = десериализация (парсинг)

        Point p  = new Point(33,44);
        Gson gson = new Gson(); // библиотека
        String s = gson.toJson(p);
        System.out.println(s);
        // JSON = JavaScript Object Notation

        String stringPoint = "{'x':10, 'y':20}";
        // <point><x>10</x><y>20</y></point>
        // <point x=10 y=10/>

        Point pp = gson.fromJson(stringPoint, Point.class);

        System.out.println(pp.getX() + " " + pp.getY());


    }
}
