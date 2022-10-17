package Lesson21;

//Напишите функцию которая получает на вход список строк и возвращает Map ключ которой это слово,
// а значение это список номеров строк, в которых это слово встречалось (concordance)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HomeWork21 {
    public static void main(String[] args) {
        List<String> count = new ArrayList<>();
        count.add("В двух семьях, с равной знатностью и славой,");
        count.add("В Вероне пышной разгорелся вновь");
        count.add("Вражды минувш их дней раздор кровавый,");
        count.add("Заставив литься с мирных граждан кровь.");
        count.add("Из чресл враждебных, под звездой злосчастной,");
        count.add( "По совершенье  их судьбы ужасной");
        count.add( "Вражда отцов с их смертью умерла.");

        System.out.println(countStrings(count));
    }
    public static long countStrings(List<String> lines)
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
