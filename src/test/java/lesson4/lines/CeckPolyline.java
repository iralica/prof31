package lesson4.lines;

import Lesson4.Lines.Point;
import Lesson4.Lines.PolyLine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CeckPolyline {
    @Test
    public void checkPolylineLength()
    {
        List<Point> p = new ArrayList<>();
        p.add(new Point(0,0));
        p.add(new Point(1,0));
        p.add(new Point(1,1));
        p.add(new Point(0,1));
        PolyLine pl = new PolyLine(p);
        assertEquals(3, pl.getLength(), 0.001);
    }

}
