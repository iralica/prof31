package Lesson4.Lines;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure {
    private List<Point> points = new ArrayList<>();

    public Triangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                '}';
    }

    // method overloading - перегрузка методов
    private double getLength(Point p0, Point p1)
    {
        return Math.sqrt(
                Math.pow(p1.getX()-p0.getX(), 2) + Math.pow(p1.getY()-p0.getY(), 2)
        );
    }


    // overriding - переопределение метода суперкласса
    @Override
    public double getLength() {
        Point p0 = points.get(0);
        Point p1 = points.get(1);
        Point p2 = points.get(2);
        return getLength(p0, p1 ) + getLength(p1, p2) + getLength(p2, p0);
    }
    public void add (Point Point){
        Point.add(Point);
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        Point P0 = new Point(2, 2);
        Point P1 = new Point(6, 6);
        Point P2 = new Point(8, 8);
        points.add(P0);
        points.add(P1);
        points.add(P2);
        System.out.println(points);

    }
}


