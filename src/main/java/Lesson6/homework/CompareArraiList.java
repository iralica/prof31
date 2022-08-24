package Lesson6.homework;

//Напишите функцию, которая последовательно сравнивает между собой элементы из двух передаваемых в нее списков одинаковой длины.
//Если все элементы в списках попарно одинаковы, возвращает true. Пример: {1,2,3}, {4,5,6} -> false; {1,2}, {1,2} -> true; {1,2}, {2,1} -> false

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareArraiList {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> l4 = new ArrayList<>(Arrays.asList(2, 1));
        ArrayList<Integer> l5 = new ArrayList<>(Arrays.asList(1, 2));
        boolean b1 = l1.equals(l2);
        System.out.println(b1);
        boolean b2 = l3.equals(l5);
        System.out.println(b2);
        boolean b3 = l4.equals(l5);
        System.out.println(b3);

        System.out.println(checkList(l1, l2));
    }

    private static boolean checkList(List<Integer> l1, List<Integer> l2){
        for (int i = 0; i < l1.size(); i++) {
            if(!l1.get(i).equals(l2.get(i)))
                return false;
        }
        return true;
    }

}
