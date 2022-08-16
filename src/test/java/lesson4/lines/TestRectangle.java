package lesson4.lines;

import Lesson4.Lines.Point;
import Lesson4.Lines.Rectangle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestRectangle {
    @Test
    public void testrectangle(){
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
        assertEquals(17.09083264, po.getLength(), 0.0001);
    }

}
