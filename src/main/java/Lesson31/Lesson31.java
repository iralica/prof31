package Lesson31;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson31 {
    public static void main(String[] args) {
        List<String> names = List.of("Max", "Dina", "Vasya", "Svetlana");
        // распечатать самое длинное
        names.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(
                        System.out::println
                );

        Map<String, Integer> salary = new HashMap<>();
        salary.put("Alex", 23_000);
        salary.put("Masha", 25_000);
        salary.put("Dima", 32_000);
        // распечатайте имя человека кто получает минимальную зарплату
        salary.entrySet().stream() // Stream< Entry<String, Integer> >
                .min(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(
                        entry -> System.out.println(entry.getKey())
                );



    }
}
