package Lesson44.HomeWork;

import java.util.*;
import java.util.stream.Collectors;


public class SummOddElementsArray {
    public static void main(String[] args) {
        int [] a = new int[] {1,3,5,7};

        List<String> list = Arrays.asList("Max", "Rosa", "Martin", "Nika", "Lunardi", "Vino");

        int result = Arrays.stream(a)
                .filter(x -> x%2 !=0)
                .sum();
        System.out.println(result);

        List<String> result1 = list.stream()
                                 .sorted(Comparator.comparing(s -> s.substring(1)))
                .collect(Collectors.toList());
        System.out.println(result1);


    }
}
