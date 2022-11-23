package Lesson44.HomeWork;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SummOddElementsArray {
    public static void main(String[] args) {
        //                0   1   2  3  4   5
        int[] numbers = {2, 14, 22, 1, 17, 8};
        // С помощью Stream-ов посчитайте сумму нечетных элементов
        // массива целых - воспользуйтесь IntStream.range(0, ...)
        // для генерации последовательности номеров элементов -
        // подумайте, как превратить их в нечетные числа?

        int result =
                IntStream.range(0, numbers.length / 2) // 0 1 2
                        // 2*N + 1
                        .map(i -> 2 * i + 1) // 1 3 5
                        .map(i -> numbers[i]) // 14 1 8
                        .sum();

//                .reduce(new IntBinaryOperator() {
//                    @Override
//                    public int applyAsInt(int left, int right) {
//                        return left + right;
//                    }
//                });
        // .forEach(System.out::println);
        System.out.println(result);

        // С помощью Stream-ов отсортируйте список строк, сравнив их по
        // подстрокам со ВТОРОГО символа по последний. Т.е.,
        // для элемента "Max" подстрока для сравнения должна быть "ax".

        List<String> names = List.of("Max", "Masha", "Alex", "Kolya", "Dina");

        // names.add("Misha");

        names.stream()
                .sorted(
                        Comparator.comparing(string -> string.substring(1))
                )
                .forEach(System.out::println);

        // С помощью Stream-ов отфильтруйте список строк, распечатав только те из них,
        // которые являются палиндромами - т.е., одинаково выглядят при чтении вперед и
        // назад - например, "алла".

        List<String> pali = List.of(
                "алла",
                "modum",
                "hello",
                "ask",
                "a"
        );

        pali.stream()
                .filter(string -> isPalindrome(string))
                .forEach(System.out::println);

    }

    public static boolean isPalindrome(String s)
    {
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }
}
