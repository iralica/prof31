package Lesson31;
import Lesson29.Probe;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListTest {
    @Test
    public void testProbeMessage() {
        List<String> words = List.of("Hello", "Hell");

        // проверьте что каждый элемент начинается на "H" и содержит "ll"
        // до 19:35

        //assertThat(words, anyOf(hasItem(startsWith()"H"),hasItem("ll")));
    }
    @Test
    public void testList()
    {
        List<String> words = List.of("Hello", "Hell");
        assertThat(words, allOf(everyItem(startsWith("H")), everyItem(containsString("ll"))));
    }

}
