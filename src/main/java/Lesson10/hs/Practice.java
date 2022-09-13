package Lesson10.hs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        System.out.println(
                getUniqueChars("Hello, world")
        );

    }
    public static Collection<Character> getUniqueChars(String string)
    {
        Set<Character> chars = new HashSet<>();
        for(char c: string.toCharArray())
            chars.add(c);

        return chars;
    }

}
