package Lesson21;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class ConcordanceCollection {
    public static void main(String[] args) {
        List<String> lines = List.of("one two three", "four five six one", "one two five");

        // System.out.println(getConcordance(lines));
        System.out.println(getConcordance1(lines));



    }
    public static Map<String, Set<Integer>> getConcordance(List<String> lines){
        return
                IntStream.range(0, lines.size())
                        .mapToObj(number -> new AbstractMap.SimpleEntry<Integer, String>(number, lines.get(number)))
                        // SimpleEntry
                        // getKey()  getValue()
                        // 0 -> "one two three"
                        // 1 -> "four five six one"
                        // 2 -> "one two five"
                        .flatMap(pair -> Arrays.stream(pair.getValue().split(" "))
                                .map(word -> new AbstractMap.SimpleEntry<String, Integer>(word, pair.getKey()))
                        )
                        // one -> 0
                        // two -> 0
                        // three -> 0
                        // four -> 1
                        // ...
                        // one -> 1
                        .collect(new Collector<
                                AbstractMap.SimpleEntry<String, Integer>, // тип элемента в потоке
                                Map<String, Set<Integer>>, // тип в который происходит аккумуляция
                                Map<String, Set<Integer>> // тип который возвращается после finisher-а
                                >() {
                            // supplier вызывается первым и создает коллекцию для аккумулятора
                            @Override
                            public Supplier<Map<String, Set<Integer>>> supplier() {
                                return TreeMap::new;
                            }

                            // имеется коллекция-аккумулятор, в который нужно записать новый элемент из потока
                            @Override
                            public BiConsumer<
                                    Map<String, Set<Integer>>,
                                    AbstractMap.SimpleEntry<String, Integer>
                                    > accumulator() {
                                return (map, entry) -> {
                                    String key = entry.getKey();
                                    // посмотреть, есть ли в мапе Set с нужным ключом (словом)
                                    // если сета в мапе нету, его нужно создать
                                    Set<Integer> set = map.containsKey(key) ? map.get(key) : new TreeSet<>();
                                    // в сет добавить новый номер строки
                                    set.add(entry.getValue());
                                    // сохранить в мапу пару из слова-ключа и сета с номерами строк
                                    map.put(key, set);
                                };
                            }

                            // combiner используется для объединения двух мап,
                            // которые созданы в разных потоках
                            @Override
                            public BinaryOperator<Map<String, Set<Integer>>> combiner() {
                                return (f, s) -> {
                                    // добавляем в первую мапу все элементы из второй
                                    f.putAll(s);
                                    // и возвратим ее
                                    return f;
                                };
                            }

                            @Override
                            public Function<Map<String, Set<Integer>>, Map<String, Set<Integer>>> finisher() {
//                        return new Function<Map<String, Set<Integer>>, Map<String, Set<Integer>>>() {
//                            @Override
//                            public Map<String, Set<Integer>> apply(Map<String, Set<Integer>> map) {
//                                return map;
//                            }
//                        };
                                return Function.identity();
                            }

                            // Characteristics.UNORDERED - элементы возвращаются в произвольном порядке
                            // Characteristics.IDENTITY_FINISH - функция finisher ничего не делает и поэтому может не вызываться
                            // Characteristics.CONCURRENT - можно выпонять аккумуляцию в нескольких потоках (Thread)
                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                            }
                        });
    }

    public static Map<String, Set<Integer>> getConcordance1(List<String> lines){
        return
                IntStream.range(0, lines.size())
                        .mapToObj(number -> new AbstractMap.SimpleEntry<Integer, String>(number, lines.get(number)))
                        // SimpleEntry
                        // getKey()  getValue()
                        // 0 -> "one two three"
                        // 1 -> "four five six one"
                        // 2 -> "one two five"
                        .flatMap(pair -> Arrays.stream(pair.getValue().split(" "))
                                .map(word -> new AbstractMap.SimpleEntry<String, Integer>(word, pair.getKey()))
                        )
                        // one -> 0
                        // two -> 0
                        // three -> 0
                        // four -> 1
                        // ...
                        // one -> 1
                        .collect(
                                (Supplier<Map<String, Set<Integer>>>) TreeMap::new, // supplier
                                (map, entry) -> { // accumulator
                                    String key = entry.getKey();
                                    // посмотреть, есть ли в мапе Set с нужным ключом (словом)
                                    // если сета в мапе нету, его нужно создать
                                    Set<Integer> set = map.containsKey(key) ? map.get(key) : new TreeSet<>();
                                    // в сет добавить новый номер строки
                                    set.add(entry.getValue());
                                    // сохранить в мапу пару из слова-ключа и сета с номерами строк
                                    map.put(key, set);
                                },
                                Map::putAll // combiner
                        );
    };


}
