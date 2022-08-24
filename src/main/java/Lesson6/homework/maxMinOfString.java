package Lesson6.homework;

import java.util.Arrays;
import java.util.List;
//Напишите функцию которая получает на вход список строк и
// возвращает либо самую короткую либо саму длинную, в зависимости от того,
// какая встретилась раньше.
public class maxMinOfString {

    public static void main(String[] args) {
        List<String> s1 = Arrays.asList("Look a day today", "Max", "is", "big boss");
        System.out.println(compareString(s1));
        List<String> s2 = Arrays.asList("Look", "Max", "is", "big boss");
        System.out.println(compareString(s2));
    }

    public static String compareString(List<String> s) {
     String min = s.get(0);
     String max = s.get(0);
     int minPos = 0;
     int maxPos = 0;
        for (int i = 0; i < s.size(); i++) {
         String t = s.get(i);
            if (t.length() < min.length()) {
                min = t;
                minPos = i;
            }
            if (t.length() > max.length()) {
                max = t;
                maxPos = i;
            }
        }
        if (minPos <= maxPos)
            return min;
        else
            return max;
    }

}