package Lesson12.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Напишите функцию для сравнения двух сетов -
//boolean checkSets(Set<String> s1, Set<String> s2) -
// использовать любые операции кроме Set.equals()
public class SetComparator {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        Set<String> s2 = new HashSet<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        long before = System.currentTimeMillis();
        System.out.println(checkSets(s1, s2));
        long after = System.currentTimeMillis();
        System.out.println(after-before);

    }
   public static boolean checkSets(Set<String> s1, Set<String> s2){
       // 1 указывают ли s1 и s2 на один и тот-же объект
       if(s1 == s2)
           return true;
       // 2 не null оба
       if(s1 == null || s2 == null)
           return false;
       // 3 сеты разного размера не равны
       if(s1.size() != s2.size())
           return false;
       // 4 все элементы одного сета содержаться в другом сете
       for(String string:s1)
       {
           if(!s2.contains(string))
               return false;
       }
       return true;
   }

}
