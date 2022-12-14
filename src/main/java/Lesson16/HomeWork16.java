package Lesson16;

import java.util.TreeMap;
import java.util.TreeSet;

// ДЗ проф ява:
// 2. ** Написать метод, принимающий на вход список слов и возвращающий TreeMap с ключами в виде первой буквы
//  и отсортированного по возрастанию TreeSet<String> со словами в которых эта буква первая.
// Пример: ["Hello", "Hell", "World"] -> {"H": ["Hell", "Hello"],  "W":["World"]}.
// TreeMap<String, TreeSet<String>>.
public class HomeWork16 {
    public static void main(String[] args) {
        String[] strings = new String[]{"Hello", "Hell", "World"};
        System.out.println((sortedTreeSet(strings)));
    }
    public static TreeMap <String, TreeSet<String>> sortedTreeSet(String [] s){
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        // в цикле пробежаться по словам
        for(String w: s) {
            // получить с каждого первую букву
            String key = "" + w.toCharArray()[0];
            // по букве получить из ret TreeSet
            TreeSet<String> vals = map.get(key);
            // если TreeSet null то создать новый
            if(vals == null)
                vals = new TreeSet<>();
            // добавить слово в TreeSet
            vals.add(w);
            // обновить пару первая буква -> TreeSet в res
            map.put(key, vals);
        }
        // возвратить res
        return map;
    }
    public static TreeMap <String, TreeSet<String>> sortedTreeSetTwo(String [] strings){
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        for (String string : strings) {
            StringBuilder firstLetter = new StringBuilder();
            TreeSet<String> currentStringTreeSet = new TreeSet<>();
            firstLetter.append(string.charAt(0));
            if (map.containsKey(firstLetter.toString())) {
                currentStringTreeSet = map.get(firstLetter.toString());
            }
            currentStringTreeSet.add(string);
            map.put(firstLetter.toString(), currentStringTreeSet);
        }
        return map;
    }
}
