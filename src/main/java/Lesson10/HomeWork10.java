package Lesson10;
// ДЗ проф ява:
// 1. Напишите функцию, которая принимает на вход строку,
// разбивает ее на слова по пробелу и на выход отдает коллекцию слов-дубликатов.
// Т.е. слов, которые присутствуют в строке более чем один раз.
// Пример: "части веб-сайтов которые вы посетили. Узнайте, как вы можете удалить его,
// чтобы исправить проблемы с работой и отображением веб-сайтов" -> ["веб-сайтов", "вы"].

// 2. * Напишите функцию, которая принимает на вход строку,
// разбивает ее на слова по пробелу и выводит на экран каждое слово и
// сколько раз это слово встретилось в строке.
// Пример: "один раз это один раз" распечатать "один":2, "раз":2, "это":1.


import java.util.*;

public class HomeWork10 {
    public static void main(String[] args) {
        String String = "Кэш Firefox временно хранит части веб-сайтов, " +
                "которые вы посетили. Узнайте, как вы можете удалить его, " +
                "чтобы исправить проблемы с работой и отображением веб-сайтов.";

        System.out.println(getDuplicates(String));

        String String2 = "один раз это один раз";
        wordsCounter(String2);
    }

    public static Collection<String> getDuplicates(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\.", "");
        s = s.replaceAll(",", "");
        String[] tokens = s.split(" ");

        Set<String> words = new HashSet<>();       // список слов
        Set<String> duplicates = new HashSet<>();  // список дубликатов
        for (String w : tokens) {
            if (words.contains(w)) {
                duplicates.add(w);
            } else {
                words.add(w);
            }
        }
        return duplicates;
    }

    public static class Word {
        public String key;
        public int count = 0;

        public Word(String a) {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            //if (count != word.count) return false; // не хочу сравнивать по количеству
            return Objects.equals(key, word.key);
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + count;
            return result;
        }
    }
    public static void wordCounter(String s)
    {
        Set<Word> w = new HashSet<>();
        for (String a : s.split(" "))
        {
            Word d = new Word(a);
            if(w.contains(d))
            {
                d = findWord(w, d);
            }
            d.count++; // в любом случае увеличиваем количество слов на 1
            w.add(d);
        }
    }
    private static Word findWord(Set<Word> w, Word d){
        for (Word ww : w){

        }
        return d;
    }
    private static void wordsCounter(String string) {
        List<String> words = new ArrayList<>(Arrays.asList(string.split("\\s")));
        Set<String> newWords = new HashSet<>(words);
        for (int i = 0; i < newWords.size(); i++) {
            StringBuilder sB = new StringBuilder(words.get(i));
            int count = 0;
            for (String word : words) {
                if (sB.toString().equals(word)) {
                    count++;
                }
            }
            if (i < newWords.size() - 1) {
                System.out.print(sB + ": " + count + ", ");
            } else System.out.print(sB + ": " + count + ".");
        }
    }
}
