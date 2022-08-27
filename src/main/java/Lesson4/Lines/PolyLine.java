package Lesson4.Lines;


import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Figure {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

//    public void appendPoint(Point p) {
//        points.add(p);
//    }

    public PolyLine appendPoint(Point p)
    {
        points.add(p);
        return this;
    }


//    @Override
//    public String toString() {
//        String s = "PolyLine points: " + '\n';
//        for (int i = 0; i < points.size(); i++) {
//            if (i < points.size() - 1) {
//                s += "point " + (i + 1) + ": " + points.get(i) + ";" + '\n';
//            } else {
//                s += "point " + (i + 1) + ": " + points.get(i) + ".";
//            }
//        }
//        return s;
//    }

    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        b.append("Polyline {");
        for (int i = 0; i < points.size(); i++) {
            b.append("\t");
            b.append(points.get(i));
        }
        b.append("}");
        return b.toString();
    }


    private double getLength(Point p0, Point p1) {
        return Math.sqrt(
                Math.pow(p1.getX() - p0.getX(), 2) + Math.pow(p1.getY() - p0.getY(), 2)
        );
    }

    @Override
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).getLength(points.get(i + 1));
        }
        return length;
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

        PolyLine l = new PolyLine(points);
        l.appendPoint(new Point(2, 6 ));
        l.appendPoint(new Point(4, 8 ));
        System.out.println("Polyline length: " + l.getLength());
        System.out.println("----------");
        System.out.println(points);
        System.out.println("----------");
    }

}
