package Lesson50.iterator.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairTester {
    public static void main(String[] args) {

        List<Pair<String, Integer>> people = new ArrayList<>(
                Arrays.asList(new Pair<>("Masha", 23), new Pair<>("Sasha", 27), new Pair<>("Anfisa", 25))
        );
        System.out.println(people);
        Collections.sort(people);
        System.out.println(people);
    }
}
    class PairAgeComparator <K extends Comparable<K>,V extends Comparable<V>> implements Comparator<Pair<K,V>> {

        @Override
        public int compare(Pair<K, V> o1, Pair<K, V> o2) {
            // напишите сравнение по значениям
            return 0;
        }
    }


