package Lesson24;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JustTest {
    @Test
    public  void test123()
    {
        List<String> months = List.of("january", "february", "march", "june", "march");

        Set<String> res = Lesson24.filterList(months, "r");
        assertEquals(res.size(), 3);
        assertTrue(res.contains("january"));
        assertTrue(res.contains("february"));
        assertTrue(res.contains("march"));

    }

}
