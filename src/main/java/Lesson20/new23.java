package Lesson20;


import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.security.KeyStore;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class new23 {

    public static void main(String[] args) {
        List<String> count = new ArrayList<>();
        count.add("В двух семьях, равных знатностью и славой,");
        count.add("В Вероне под пышной разгорелся и вновь");
        count.add("Вражды минувших дней раздор кровавый,");
        count.add("Заставив литься мирных граждан кровь.");
        count.add("Из чресл враждебных, под  двух звездой злосчастной,");
        count.add("Любовников чета их произошла.");
        count.add( "По совершенье их судьбы ужасной");
        count.add( "Вражда отцов с их смертью умерла.");

        

        Map<String, Set <Integer>> map =
                count.stream()
                        .collect(new Collector<String, Map<String, Set <Integer>>, Map<String, Set <Integer>>>(){

                            @Override
                            public Supplier<Map<String, Set<Integer>>> supplier() {
                                return new Supplier<>() {
                                    int count = 0;
                                    @Override
                                    public Map<String, Set<Integer>> get() {
                                        return new HashMap<>();
                                    }
                                };
                            }

                            @Override
                            public BiConsumer<Map<String, Set<Integer>>, String> accumulator() {
                                return (map, s) -> {
                                    Arrays.asList(s.split(" ")).forEach(s -> {
                                        Set<Integer> l1 = (map.containsKey(s)) ? map.get(s) : new HashSet<>();
                                        l1.add(count);
                                        map.put(s, l1);
                                    });
                                    ++cnt;
                                };
                                };
                            }

                            @Override
                            public BinaryOperator<Map<String, Set<Integer>>> combiner() {
                                return (f, s) -> {
                                    f.putAll(s);
                                    return f;
                                };
                            }

                            @Override
                            public Function<Map<String, Set<Integer>>, Map<String, Set<Integer>>> finisher() {
                                return map -> map;
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);;
                            }
                        });
    }

}
