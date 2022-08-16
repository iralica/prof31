package lesson4.lines;

import Lesson4.Lines.Point;
import Lesson4.Lines.Triangle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestTriangle {
    @Test
    public void testTriangle (){
        List<Point> points = new ArrayList<>();
        Point P0 = new Point(2, 2);
        Point P1 = new Point(6, 6);
        Point P2 = new Point(8, 8);
        points.add(P0);
        points.add(P1);
        points.add(P2);

        Triangle t1 = new Triangle(points);
        assertEquals(16.970562748477143, t1.getLength(), 0.0001);
    }
}
