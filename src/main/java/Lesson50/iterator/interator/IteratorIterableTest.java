package Lesson50.iterator.interator;

import java.util.*;

public class IteratorIterableTest {
    public static void main(String[] args) {
        List<String> stringList = List.of("dina", "masha", "sveta");
        iteratorWalk(stringList.iterator());

        Map<String, Integer> ages = Map.of(
                "dina", 33, "masha", 24, "sveta", 31
        );


        iteratorWalk(ages.entrySet().iterator());

        Set<Integer> salary = Set.of(12_000, 14_000, 8_500);

        iteratorWalk(salary.iterator());

        /*
        interface Iterator<T> {
            boolean hasNext();
            T next();
        }

        interface Iterable<T> {
            Iterator<T> iterator();
        }

         */

        for(String s: stringList)
        {
            System.out.println("for: " + s);
        }

        for(Integer i: salary)
        {
            System.out.println("salary: " + i);
        }

        for(Map.Entry<String, Integer> p : ages.entrySet())
        {
            System.out.println("pair: " + p);
        }

    }

    public static <T> void iteratorWalk(Iterator<T> iterator)
    {
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}