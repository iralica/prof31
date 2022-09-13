package lesson11.deque;

import Lesson11.CustomArrayDeque;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DequeTest {
    @Test
    public void testAddFirst()
    {
        CustomArrayDeque d = new CustomArrayDeque();
        d.addFirst(50);
        d.addFirst(40);
        d.addFirst(30);
        d.addFirst(20);
        d.addFirst(10);
        assertEquals("[10, 20, 30, 40, 50]", d.toString());
    }


    @Test
    public void testAddLast()
    {
        CustomArrayDeque d = new CustomArrayDeque();
        d.addLast(10);
        d.addLast(20);
        assertEquals("[10, 20]", d.toString());
        System.out.println(d);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowsExceptionGettingElementFromEmptyDeque()
    {
        CustomArrayDeque d = new CustomArrayDeque();
        d.getLast();
    }

    @Test
    public void testRemoveLast()
    {
        CustomArrayDeque d = new CustomArrayDeque();
        d.addLast(10);
        d.addLast(20);
        assertEquals(20, d.removeLast());
        assertEquals(1, d.size());
        assertEquals("[10]", d.toString());
    }

}
