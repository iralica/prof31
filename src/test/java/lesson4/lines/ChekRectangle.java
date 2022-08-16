package lesson4.lines;

import Lesson4.Lines.Point;
import Lesson4.Lines.Rectangle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChekRectangle {
    @Test
    public void checkRectangleLength()
    {
        List<Point> p = new ArrayList<>();
        p.add(new Point(0,0));
        p.add(new Point(1,0));
        p.add(new Point(1,1));
        p.add(new Point(0,1));
        Rectangle r = new Rectangle(p);
        assertEquals(4, r.getLength(), 0.001);
    }
}

