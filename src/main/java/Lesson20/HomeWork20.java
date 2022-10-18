package Lesson20;

//Напишите функцию которая принимает на вход список строк - например, строчки из книги. Функция должна подсчитать количество уникальных слов в списке.
 //Считаем что слова отделяются друг от друга пробелами.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HomeWork20 {
    public static void main(String[] args) {
        List<String> count = new ArrayList<>();
        count.add("В двух семьях, равных знатностью и славой,");
        count.add("В Вероне пышной разгорелся вновь");
        count.add("Вражды минувших дней раздор кровавый,");
        count.add("Заставив литься мирных граждан кровь.");
        count.add("Из чресл враждебных, под звездой злосчастной,");
        count.add("Любовников чета произошла.");
        count.add( "По совершенье  их  судьбы ужасной");
        count.add( "Вражда отцов с их смертью умерла.");

        System.out.println(
                count.stream()
                        .map(s -> s.replaceAll("[—.,:-]", ""))
                        .map(s -> s.replaceAll("\s+", " "))
                        .map(String::toLowerCase)
                        .flatMap(line -> Arrays.stream(line.split(" ")))
                        .distinct()
                        .count()
        );

        System.out.println(countUniqueWords(count));
    }
    public static long countUniqueWords(Collection<String> lines)
    {
        return
                lines.stream()
                        .map(s -> s.replaceAll("[—.,:-]", ""))
                        .map(s -> s.replaceAll("\s+", " "))
                        .map(String::toLowerCase)
                        .flatMap(s -> Arrays.stream(s.split(" ")))
                        .distinct()
                        .count();
    }
}
