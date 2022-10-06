package Lesson19;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        // Stream API: Stream, primitive streams. Intermediate and Terminal operations.
        List<Integer> years = List.of(2000, 2022, 2021, 2027);
        //Stream<Integer> yearsStream = years.stream(); // создание потока
        Stream<Integer> yearsStream = years.stream() // stream creation
                .filter(y -> y % 2 == 0) // intermediate operation
                .filter(y -> y > 2010); // intermediate operation

        yearsStream.forEach(System.out::println); // terminal operation

        // создайте поток из имен Alexandex, Max, Xenia, Maria
        // пропускайте только те имена, в которых есть буква 'n'
        // и распечатайте каждое из них на экране
        // до 19:19
        List<String> names = List.of("Alexander", "Max", "Xenia", "Maria");
        names
                .stream()
                .filter(s -> s.contains("n"))
                .forEach(s -> System.out.println("name is: " + s));


        Stream<Double> randomStream =
                Stream.generate(() -> Math.random())
                        .limit(5); // сгенерировать

        randomStream.forEach(System.out::println);

        Arrays.stream(new Integer[]{1, 2, 3})  // 1 -> 1*1, 2 -> 2*2 ...
                .map(i -> i * i)
                .forEach(System.out::println);
        ;

        names.stream()
                .map(s -> s.length())
                .forEach(System.out::println);

        names.stream()
                .map(s -> s + ":" + s.length())
                .skip(1)
                .sorted()
                .forEach(System.out::println);

        // как нам отправлять запросы потоку целиком?
        // есть ли хотябы один элемент, удовлетворяющий предикату
        System.out.println(
                names.stream().anyMatch( s -> s.contains("X"))
        );
        // все ли элементы удовлетворяют предикату
        System.out.println(
                names.stream().allMatch( s -> s.contains("X"))
        );
        // ни один элемент предикату не удовлетворяет
        System.out.println(
                names.stream().noneMatch( s -> s.contains("X"))
        );

        // Reduction 1 + 2 + 3
        int sum = Arrays.stream(new Integer[] {1,2,3})
                .reduce(0,
                        (prev, curr) -> prev+curr);

        int mult = Arrays.stream(new Integer[] {2,6,3, 5})
                .reduce(1,
                        (prev, curr) -> prev*curr);
        System.out.println(mult);

        names.stream()
                .reduce((p, c) -> p + ", " + c)
                .ifPresent(System.out::println);

        Optional<String> maxString =
                names.stream()/*.filter(s -> s.contains("W"))*/.max(Comparator.naturalOrder());

        if(!maxString.isEmpty())
            System.out.println(maxString.get());

        names.stream()
                .filter(s -> s.contains("a"))
                .max(Comparator.naturalOrder())
                .ifPresent(s -> System.out.println("max string: " + s));
         // Collector
        // механизм сохранения элементов потока в коллекцию
        List<String> filteredNames =
                names.stream()
                        .filter(s -> s.contains("e"))
                        .map(s -> s + ":" + s.length())
                        .collect(Collectors.toList());

        // Map<String, Integer>
        Map<String, Integer> nameToLength =
                names.stream()
                        .collect(
                                Collectors.toMap(
                                        name -> name,
                                        name -> name.length()
                                )
                        );
        System.out.println(nameToLength);

        String namesCombined =
                names.stream()
                        .collect(
                                Collectors.joining()
                        );


    }

    public static boolean containsString(List<String> l, String string) {
        for (String s : l)
            if (s.contains(string))
                return true;
        return false;
    }
}