package Lesson22.Lesson23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class HomeWork1 {
    //Напишите коллектор который из потока целых вычисляет Double среднее значение
    public static void main(String[] args) {
        int [] ints = {1, 2,3, 4, 5};
        Arrays.stream(ints)
                .parallel()
                .boxed()
                .collect(new Collector<Integer, List<Integer>, Double>() {
                    @Override
                    public Supplier<List<Integer>> supplier() {
                        return ArrayList::new;
                    }

                    @Override
                    public BiConsumer<List<Integer>, Integer> accumulator() {
                        return List::add;
                    }

                    @Override
                    public BinaryOperator<List<Integer>> combiner() {
                        return (f, s) -> {
                            f.addAll(s);
                            return f;
                        };
                    }

                    @Override
                    public Function<List<Integer>, Double> finisher() {
                        return list -> list.stream().reduce(0, Integer::sum).doubleValue()/ list.size();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.UNORDERED);
                    }
                });
    }
}
