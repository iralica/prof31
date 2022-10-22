package Lesson21;

//Напишите функцию которая получает на вход список строк и возвращает Map ключ которой это слово,
// а значение это список номеров строк, в которых это слово встречалось (concordance)

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork21 {
    public static void main(String[] args) {
        List<String> count = List.of("В двух семьях, с равной знатностью и славой,",
        "В Вероне пышной разгорелся вновь",
        "Вражды минувш их дней раздор кровавый,",
        "Заставив литься с мирных граждан кровь.",
        "Из чресл враждебных, под звездой злосчастной,",
        "По совершенье  их судьбы ужасной",
        "Вражда отцов с их смертью умерла.");

        TreeMap<String, Set<Integer>> result = new TreeMap<>(getConcordance(count));
        System.out.println(
                result
        );
    }
    public static Map<String, Set<Integer>> getConcordance(List<String> lines) {
        // вычистить строки от пунктуации
        // как-то сделать пары из строки и номера строки
        // номер строки -> строка
        // слово -> номер строки
//        SimpleEntry<String, Integer> pa = new SimpleEntry<>("hello", 33);
//        pa.getValue() // 33
//        pa.getKey() // hello

        Map<String, List<AbstractMap.SimpleEntry<String, Integer>>>
                mapWordToLineNumber =
                IntStream.range(0, lines.size()) // int
                        // boxed int -> Integer
                        .mapToObj(i -> new AbstractMap.SimpleEntry<Integer, String>(i, lines.get(i))) // Pair<Integer, String>
                        .flatMap(pair ->
                                Arrays.stream(pair
                                        .getValue() // каждая строка
                                        .toLowerCase()
                                        .replaceAll("\\p{Punct}", "") // удаляем пунктуацию
                                        .split("\\s+") // разбиваем по пробелу
                                ).map(word -> new AbstractMap.SimpleEntry<String, Integer>(word, pair.getKey()))
                        ) // SimpleEntry<String, Integer>
                        .collect(Collectors.groupingBy(
                                AbstractMap.SimpleEntry::getKey
                        )); // Map<String, List<SimpleEntry<String, Integer>>>

        List<AbstractMap.SimpleEntry<String, Set<Integer>>> result =
                mapWordToLineNumber.entrySet().stream()
                        .map(pair -> new AbstractMap.SimpleEntry<String, Set<Integer>>(
                                pair.getKey(),
                                pair.getValue().stream().map(AbstractMap.SimpleEntry::getValue).collect(Collectors.toCollection(TreeSet::new)))
                        )
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList());
        // System.out.println(result);

        return result.stream().collect(Collectors.toMap(
                AbstractMap.SimpleEntry::getKey,
                AbstractMap.SimpleEntry::getValue
        ));


    }

}
