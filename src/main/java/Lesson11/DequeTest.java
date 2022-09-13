package Lesson11;

import java.util.concurrent.Callable;

public class DequeTest {
    public static void main(String[] args) {
        CustomArrayDeque d = new CustomArrayDeque();
        d.addFirst(50);
        d.addFirst(40);
        d.addFirst(30);
        d.addFirst(20);
        d.addFirst(10);


        System.out.println(d);

    }
}
