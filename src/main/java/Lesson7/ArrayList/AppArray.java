package Lesson7.ArrayList;

import java.util.Iterator;

public class AppArray {
    public static void main(String[] args) {
        System.out.println("--------------------");
        MyCustomArrayList list = new MyCustomArrayList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.print();
        list.remove(1);
        list.print();

        System.out.println("--------------------");
        int[] arr = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        list.append(arr);
        list.print();

        System.out.println("--------------------");
        Iterator<Integer> myIterator = list.iterator();
        while (myIterator.hasNext()) {
            System.out.println("iterator next: " + myIterator.next());
        }
        System.out.println("----------");
        for (Object i: list) {
            System.out.println("My list: " + i);
        }

        System.out.println("----------");
        list.iterator().remove();
        for (Object i: list) System.out.println("My list: " + i);

    }

}
