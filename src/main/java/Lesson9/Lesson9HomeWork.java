package Lesson9;

// ДЗ проф ява:
// У нас есть список стран
// countries = ["Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"]
// и есть список слов
// words = ["Andorra", "Canada", "First", "candy", "Argentina",
// "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba"]
// нужно получить список всех стран из списка слов, начинающихся на "A" - т.е., ["Argentina", "Andorra"]

import java.util.*;

public class Lesson9HomeWork {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>(
                Arrays.asList("Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden")
        );
        Set<String> words = new HashSet<>(
                Arrays.asList("Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba")
        );

        // из words сохраним только то, что есть в countries
        words.retainAll(countries);

        System.out.println(words);

        // удалим страны не соответсвующие критерию
        for(String s : words) // for
        {
           // if(!s.toUpperCase().startsWith("A"))
               // words.remove(s);
        }
        Iterator<String> i = words.iterator();
        while (i.hasNext())
        {
            if(!i.next().toUpperCase().startsWith("A"))
                i.remove();
        }


        System.out.println(words);

    }

    private static Set<String> getCountriesStartedAtA(String[] countries, String[] words) {
        Set<String> countriesStartedAtA = new HashSet<>();
        Set<String> checkSet = new HashSet<>(List.of(countries));
        for (String w : words) {
            if (checkSet.contains(w) && w.charAt(0) == 'A') {
                countriesStartedAtA.add(w);
            }
        }
        return countriesStartedAtA;
    }
}
