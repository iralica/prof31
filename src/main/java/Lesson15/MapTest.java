package Lesson15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Germany", "Berlin");

        System.out.println(
                capitals.get("Germany")
        );
        capitals.put("Germany", "Frankfurt"); //перепишет значение

        System.out.println(
                capitals.get("Germany")
        );

        capitals.remove("Germany");
        System.out.println(
                capitals.get("Germany")
        );
        System.out.println(capitals.size());
        capitals.put("GB", "London");
        Iterator<Map.Entry<String, String>> it = capitals.entrySet().iterator();
        while (it.hasNext())
            System.out.println(it.next());

        String string = "performs the given action for each entry in this map until all entries have been processed or the action throws an exception";
        printWordFrequency(string);

    }
    // напишите функцию, принимающую строку, и распечатывающую частоту встречающихся в ней слов
    // слова отделяются пробелами
    // performs = 1
    // the = 1
    // до 21:06
    public static void printWordFrequency(String s){
        // разбить строку на массив строк
        // s.split(" ");
        // пробежаться по массиву и заполнить Map
        // распечатать Map
        Map<String, Integer> words = new HashMap<>();
        String [] w = s.split(" ");
        for(String word: w)
        {
            Integer number = words.get(word);
            if(number != null)
            {
                words.put(word, ++number);
            }
            else {
                words.put(word, 1);
            }
        }
        Set<String> keys = words.keySet();
        for(String word: keys)
        {
            System.out.println(word + ":" + words.get(word));
        }


    }
}
