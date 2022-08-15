package Lesson4.Lines;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Figure{
    private List<Point> points = new ArrayList<>();
    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public void appendPoint(Point p) {
        points.add(p);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("PolyLine points= ");
        for (Point p : points) {
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
        double length = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i < points.size() - 1) {
                length += getLength(points.get(i), points.get(i + 1));
            } else {
                length += getLength(points.get(i), points.get(0));
            }
        }
        return length;
    }
    public static void main(String[] args) {

    }

}
