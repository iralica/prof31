package lesson1.Date;

import Lesson1.date.Date;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDate {
    @Test
    public void testGoodDate()
    {
        assertEquals("2021-02-28", new Date(2021, 2, 28).toString());
    }

}
