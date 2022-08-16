package lesson4.lines;

import Lesson4.Lines.Point;
import Lesson4.Lines.PolyLine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPolyline {
    @Test
    public void testPolyLine(){
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

        assertEquals(24.8743317968, l.getLength(), 0.00001 );
    }
}
