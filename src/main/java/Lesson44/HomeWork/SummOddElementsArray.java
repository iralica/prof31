package Lesson44.HomeWork;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SummOddElementsArray {
    public static void main(String[] args) {
        //                0   1   2  3  4   5
        int[] numbers = {2, 14, 22, 1, 17, 8};
        // � ������� Stream-�� ���������� ����� �������� ���������
        // ������� ����� - �������������� IntStream.range(0, ...)
        // ��� ��������� ������������������ ������� ��������� -
        // ���������, ��� ���������� �� � �������� �����?

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

        // � ������� Stream-�� ������������ ������ �����, ������� �� ��
        // ���������� �� ������� ������� �� ���������. �.�.,
        // ��� �������� "Max" ��������� ��� ��������� ������ ���� "ax".

        List<String> names = List.of("Max", "Masha", "Alex", "Kolya", "Dina");

        // names.add("Misha");

        names.stream()
                .sorted(
                        Comparator.comparing(string -> string.substring(1))
                )
                .forEach(System.out::println);

        // � ������� Stream-�� ������������ ������ �����, ���������� ������ �� �� ���,
        // ������� �������� ������������ - �.�., ��������� �������� ��� ������ ������ �
        // ����� - ��������, "����".

        List<String> pali = List.of(
                "����",
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
