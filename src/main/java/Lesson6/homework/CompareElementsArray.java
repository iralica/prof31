package Lesson6.homework;
//Напишите функцию, которая последовательно сравнивает элементы двух передаваемых
//в нее списков одинаковой длины и возвращает список строк. Пример: {1,2,3}, {1,4,3}->{"Yes", "No", "Yes"}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareElementsArray {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(1, 4, 3));
        System.out.println(compareElements(l1, l2));

    }
    public static List<String> compareElements(List<Integer> a, ArrayList<Integer> b){
        List<String> c = new ArrayList<>();
        for (int i = 0; i < a.size(); i++)
            if (a.get(i).equals(b.get(i))) {
                c.add(i, "Yes");
            } else c.add(i, "No");
        return c;
    }
}
