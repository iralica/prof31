package Lesson4.Lines;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Figure{
    private List<Point> points = new ArrayList<>();

    public Rectangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Rectangle points= ");
        for (Point p: points){
            result.append("(").append(p.getX()).append(", ").append(p.getY()).append(")");
        }
        return result.toString();
    }
    private double getLength(Point p0, Point p1)
    {
        return Math.sqrt(
                Math.pow(p1.getX()-p0.getX(), 2) + Math.pow(p1.getY()-p0.getY(), 2)
        );
    }
    @Override
    public double getLength() {
        Point p0 = points.get(0);
        Point p1 = points.get(1);
        Point p2 = points.get(2);
        Point p3 = points.get(3);
        return getLength(p0, p1 ) + getLength(p1, p2) + getLength(p2, p3) + getLength(p3, p0);
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        Point P0 = new Point(2, 2);
        Point P1 = new Point(6, 6);
        Point P2 = new Point(8, 8);
        Point P3 = new Point(4, 5);
        points.add(P0);
        points.add(P1);
        points.add(P2);
        points.add(P3);

        Rectangle po = new Rectangle(points);
        System.out.println("Rectangle length: " + po.getLength());
        System.out.println("----------");
        System.out.println(points);
        System.out.println("----------");

    }
}
