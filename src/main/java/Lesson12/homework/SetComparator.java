package Lesson12.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Напишите функцию для сравнения двух сетов -
//boolean checkSets(Set<String> s1, Set<String> s2) -
// использовать любые операции кроме Set.equals()
public class SetComparator {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("Ann", "Tim", "Tom", "Sven", "Philip"));
        Set<String> s2 = new HashSet<>(Arrays.asList("Ann", "Tim", "Tom", "Sven", "Philip"));
        Set<String> s3 = new HashSet<>(Arrays.asList("Anet", "Tim", "Tom", "Sven", "Philip"));
        System.out.println(checkSets(s1, s1));
        System.out.println(checkSets(s1, s2));
        System.out.println(checkSets(s1, s3));
    }
   public static boolean checkSets(Set<String> s1, Set<String> s2) {
       if (s1 == s2) // не один ли объект
           return true;
       if (s1 == null || s2 == null) // не равны ли нулю
           return false;
       if (s1.size() != s2.size()) // если разные размеры соответсвено не равны
           return false;
       for (String string : s1) {
           if (!s2.contains(string))
               return false;
       }
       return true;

   }
}
