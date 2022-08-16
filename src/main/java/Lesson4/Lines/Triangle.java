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
        StringBuilder result = new StringBuilder("Triangle points= ");
        for (Point p: points){
            result.append("(").append(p.getX()).append(", ").append(p.getY()).append(")");
        }
        return result.toString();
    }

    @Override
    public double getLength() {
        Point p0 = points.get(0);
        Point p1 = points.get(1);
        Point p2 = points.get(2);
        // return getLength(p0, p1 ) + getLength(p1, p2) + getLength(p2, p0);
        return p0.getLength(p1) + p1.getLength(p2) + p2.getLength(p0);
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

        Triangle t1 = new Triangle(points);
        System.out.println("Triangle length: " + t1.getLength());
        System.out.println("----------");
        System.out.println(t1);
        System.out.println("----------");

    }
}


