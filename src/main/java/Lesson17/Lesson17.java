package Lesson17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Lesson17 {
    public static void main(String[] args) {
        NoArgsReturnsDouble noArgsReturnsDouble = (NoArgsReturnsDouble) () -> Math.random() * 256;
        System.out.println("NoArgsReturnsDouble " + noArgsReturnsDouble.function());

        TwoIntArgsReturnBoolean twoIntArgsReturnBoolean = (TwoIntArgsReturnBoolean) (a, b) -> false;

        // напишите лямбду которая сравнит два аргумента на равенство
        TwoIntArgsReturnBoolean l1 = (i, j) -> i == j; // если равны вернуть true если не равны false
        System.out.println("равенство 3, 3 " + process(l1, 3, 3));


        TwoIntArgsReturnBoolean l2 = (i, j) -> i % j == 0;
        System.out.println("делимость 50, 10 " + process(l2, 3, 3));

        PredicateInt predicateInt = b -> false;
        PredicateInt p1 = (i) -> i%2==0; //
        List<Integer> input = List.of(1,3,5,8,2,17);
        Collection<Integer> result = filter(p1, input);
        System.out.println(result);

        StringProcessor pp1 = (s) -> s.substring(0, 1);
        StringProcessor pp2 = String::toUpperCase; // lambda method reference
        System.out.println(
                process(pp1, List.of("Max", "Dina", "Alex"))
        );
        System.out.println(
                process(pp2, List.of("Max", "Dina", "Alex"))
        );


        DoubleValue d = new DoubleValue(12);
        //DoubleProcessor dp = (w) -> d.multiply(w);
        DoubleProcessor dp = d::multiply;; // lambda instance method

        DoubleValueCreator creator = (dbl) -> {return new DoubleValue(dbl);
        };

        DoubleValueCreator creator1 = DoubleValue::new; // lambda constructor reference

        GenericProcessor<String> sp1 = (s) -> s.toLowerCase();
        GenericProcessor<Double> dp1 = (dd) -> Math.pow(dd, 3);
    } // end main


    public static <K> List<K> process (GenericProcessor<K> p, List<K> input)
    {

        return input;
    }

    public static boolean process(TwoIntArgsReturnBoolean c, int k, int m)
        {
            return c.function(k, m);
        }

    // напишите функцию, которая принимает на вход Collection<Integer>, PredicateInt и
    // возвратит Collection<Integer> только для тех элементов коллекции которые удовлетворяют
    // предикату
    // boolean function(int i)
    public static Collection<Integer> filter(PredicateInt p, Collection<Integer> input)
    {
        List<Integer> result = new ArrayList<>();
        for (Integer i: input) {
           if(p.function(i))
               result.add(i);
        }
        return result;
    }

    // напишите функцию которая принимает на вход List<String> и возвращает
    // List<String> после применения StringProcessor
    public static List<String> process(StringProcessor p, List<String> input)
    {
        List<String> result = new ArrayList<>();
        for(String s: input)
            result.add( p.apply(s)  );
        return  result;
    }

}
