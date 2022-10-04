package Lesson18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson18 {
    public static void main(String[] args) {
        // Function

        Function<String, Integer> stringToLength = String::length;
        Function<Double, String> doubleString = d -> "double: " + d;

        System.out.println(doubleString.apply(334.2));

        Map<String, Integer> nameMap = new HashMap<>();
        Integer v = nameMap.computeIfAbsent("John", String::length);

        Stream.of("John", "Max", "Alexander", "Vasilisa")
                .map(String::length)
                .forEach(System.out::println);

        // compose
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Double, String> doubleQuote = quote.compose(doubleString);
        System.out.println(doubleQuote.apply(33.4));
        // thenApply
        //https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html


        // BiFunction
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 15_000);
        salaries.put("Masha", 25_000);
        salaries.put("Alex", 17_000);
        salaries.put("Samuel", 33_000);

        salaries.replaceAll(
                (name, salary) -> name.equals("Samuel")
                        ? salary : salary + 2_000);
        System.out.println(salaries);


        // Consumer
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html
        // получает аргумент какого-типа и ничего не возвращает
        // используется для сайд-эффектов
        // andThen

        Supplier<Double> lazyValue = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Math.random() * 100;
        };

        // BiConsumer
        salaries.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String name, Integer salary) {
                System.out.println("name: " + name+ ", salary: " + salary);
            }
        });

        // BiConsumer
        salaries.forEach(
                (name, salary) -> System.out.println("name: " + name+ ", salary: " + salary)
        );

        // Predicate
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
        // тест на соответствие элемента какому-нибудь условию
        // возвращает boolean
        // and() or() negate()
        // Predicate.not(...)
        // BiPredicate
        /*List<String> namesLongerThen5 =
                names
                        .stream()
                        .filter(s -> s.length() >=5)
                        .collect(Collectors.toList());
        System.out.println(namesLongerThen5);*/

        // Operator
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/UnaryOperator.html
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
        //
        List<Integer> values = Arrays.asList(3,5,8,9,12);
        int sum = values.stream()
                .reduce(0, (i1, i2)-> i1 + i2);
        System.out.println(sum);

    }
}
