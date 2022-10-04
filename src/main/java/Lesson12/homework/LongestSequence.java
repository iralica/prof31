package Lesson12.homework;

import java.util.*;

public class LongestSequence {
        public static void main(String[] args) {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            arr.add(2);
            arr.add(5);
            arr.add(6);
            arr.add(8);
            arr.add(7);
            arr.add(4);
            System.out.println(arr);
            //longestSequenceTester((ArrayList) arr);
            System.out.println(arr);
        }

    /*public static Collection<Integer> longestSequenceTester(ArrayList a){
        Set<Integer> b = new HashSet<>();
        int longSequence = 1;
        int currentSequence = 1;
        if (a.size() ==0){return b;}
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) != a.get(i - 1)) {
                if (a.get(i) == (((a.get(i)- 1)) + 1)) {
                    currentSequence += 1;
                }
                else {
                    longSequence = Math.max(longSequence, currentSequence);
                    currentSequence = 1;
                }
            }
        return b;
    }*/

    }

