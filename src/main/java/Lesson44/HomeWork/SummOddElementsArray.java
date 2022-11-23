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
    //                0   1   2  3  4   5
    //int [] numbers = {2, 14, 22, 1, 17, 8};
    // С помощью Stream-ов посчитайте сумму нечетных элементов
    // массива целых - воспользуйтесь IntStream.range(0, ...)
    // для генерации последовательности номеров элементов -
    // подумайте, как превратить их в нечетные числа?
    /*int result =
            IntStream.range(0, numbers.length / 2) // 0 1 2
                    // 2*N + 1
                    .map(i -> 2 * i + 1) // 1 3 5
                    .map(i -> numbers[i]) // 14 1 8
                    .sum();*/
}
