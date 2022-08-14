package lesson4.animals;


import Lesson4.Animals.Cat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CatTest {
    @Test
    public void testCat () {
        Cat c = new Cat ("M");
        assertEquals("Meouw",c.greets());

    }
}
