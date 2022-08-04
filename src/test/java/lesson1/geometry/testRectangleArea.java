package lesson1.geometry;

import Lesson1.geometry.Point;
import Lesson1.geometry.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testRectangleArea {
    @Test
    public void testArea (){
        Rectangle rec  = new Rectangle(
                new Point(1,1),
                new Point(5, 5)
        );
        assertEquals(16, rec.getArea());
    }


}
