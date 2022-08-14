package Lesson4.Lines;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Figure{
    private List<Point> po = new ArrayList<>();

    public Rectangle(List<Point> points) {
        this.po = po;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    private double getLength(Point p0, Point p1)
    {
        return Math.sqrt(
                Math.pow(p1.getX()-p0.getX(), 2) + Math.pow(p1.getY()-p0.getY(), 2)
        );
    }
    @Override
    public double getLength() {
        Point p0 = po.get(0);
        Point p1 = po.get(1);
        Point p2 = po.get(2);
        Point p3 = po.get(3);
        return getLength(p0, p1 ) + getLength(p1, p2) + getLength(p2, p3) + getLength(p3, p0);
    }

    public static void main(String[] args) {

    }
}
